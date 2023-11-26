package board.spring.domain;

import board.spring.dto.request.BoardUpdateRequest;
import jakarta.persistence.*;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "board_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    public Board() {}

    public Board(final String title, final String content, final Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }

    public void update(BoardUpdateRequest request){
        this.title = request.getTitle();
        this.content = request.getContent();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Member getMember() {
        return member;
    }
}
