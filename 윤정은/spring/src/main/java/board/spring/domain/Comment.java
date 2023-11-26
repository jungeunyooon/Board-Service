package board.spring.domain;

import board.spring.dto.request.CommentUpdateRequest;
import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_Id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_Id")
    private Board board;

    public Comment() {}

    public Comment(String content, Member member, Board board) {
        this.content = content;
        this.member = member;
        this.board = board;
    }

    public void update(CommentUpdateRequest request) {
        this.content = request.getContent();
    }

    public String getContent(){
        return content;
    }

    public Member getMember(){
        return member;
    }

}
