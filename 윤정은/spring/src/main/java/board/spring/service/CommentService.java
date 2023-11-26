package board.spring.service;


import board.spring.domain.Board;
import board.spring.domain.Comment;
import board.spring.domain.Member;
import board.spring.dto.request.CommentSaveRequest;
import board.spring.dto.request.CommentUpdateRequest;
import board.spring.dto.response.CommentResponse;
import board.spring.repository.BoardRepository;
import board.spring.repository.CommentRepository;
import board.spring.repository.JPQL.BoardInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardInterface boardInterface;
    private final MemberService memberService;

    public CommentService(CommentRepository commentRepository,BoardInterface boardInterface, MemberService memberService){
        this.commentRepository = commentRepository;
        this.boardInterface = boardInterface;
        this.memberService = memberService;

    }
    // 댓글 작성
    public void saveComment(CommentSaveRequest request) {
        Member member = memberService.getMemberById(request.getMemberId());
        Board board = boardInterface.findById(request.getBoardId()).orElseThrow(
                () -> new RuntimeException("존재하지 않는 회원입니다.")
        );
        Comment newComment = request.toEntity(member,board);
        commentRepository.save(newComment);
    }

    // 댓글 수정
    public void updateComment(CommentUpdateRequest request, Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new RuntimeException("존재하지 않는 게시글입니다."));
        comment.update(request);
    }


    // 댓글 삭제
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }


    // 게시글 상세 조회
    public List<CommentResponse> findCommentListByPostId(Long boardId) {
        List<Comment> CommentList = commentRepository.findAllByBoardId(boardId);

        return CommentList.stream()
                .map(CommentResponse::from)
                .collect(Collectors.toList());
    }
}

