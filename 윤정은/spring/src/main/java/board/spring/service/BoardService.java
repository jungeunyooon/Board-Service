package board.spring.service;

import board.spring.domain.Board;
import board.spring.domain.Member;
import board.spring.dto.request.BoardSaveRequest;
import board.spring.dto.response.BoardDetailResponse;
import board.spring.dto.response.BoardListResponse;
import board.spring.dto.request.BoardUpdateRequest;
import board.spring.dto.response.CommentResponse;
import board.spring.repository.BoardRepository;
import board.spring.repository.JPQL.BoardInterface;
import board.spring.repository.JPQL.MemberInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BoardService {
    private final BoardInterface boardInterface;
    private final MemberService memberService;
    private final CommentService commentService;

    public BoardService(BoardInterface boardInterface, MemberService memberService,CommentService commentService ){
        this.boardInterface = boardInterface;
        this.memberService = memberService;
        this.commentService = commentService;
    }

    // 게시글 저장
    public void savePost(BoardSaveRequest request) {
        Member member = memberService.getMemberById(request.getMemberId());
        Board board = request.toEntity(member);
        boardInterface.save(board);
    }

    // 게시글 목록 조회
    public List<BoardListResponse> findBoardList() {
        List<Board> boardList = boardInterface.findAll();
        return boardList.stream()
                .map(BoardListResponse::from)
                .collect(Collectors.toList());
    }

    // 게시글 제목으로 게시글 목록 검색
    public List<BoardListResponse> findBoardListByTitle(String title) {
        List<Board> boardList = boardInterface.findAllByTitleStartingWith(title);

        return boardList.stream()
                .map(BoardListResponse::from)
                .collect(Collectors.toList());
    }

    // 특정 회원이 작성한 게시글 조회
    public List<BoardListResponse> findPostListByEmail(Long memberId) {
        List<Board> boardList = boardInterface.findAllListByMemberId(memberId);

        return boardList.stream()
                .map(BoardListResponse::from)
                .collect(Collectors.toList());
    }

    // 게시글 상세 조회
    public BoardDetailResponse findDetail(Long boardId) {
        Board board = getBoardById(boardId);
        List<CommentResponse> commentList = commentService.findCommentListByPostId(boardId);
        return BoardDetailResponse.from(board, commentList);
    }

    public Board getBoardById(Long boardId) {
        return boardInterface.findById(boardId).orElseThrow(
                () -> new RuntimeException("존재하지 않는 게시글입니다.")
        );
    }

    // 게시물 수정
    public void updateBoard(Long boardId, BoardUpdateRequest request) {
        Board board = getBoardById(boardId);
        board.update(request);
    }

    // 게시글 삭제
    public void deletePost(Long boardId) {
        boardInterface.deleteById(boardId);
    }
}

