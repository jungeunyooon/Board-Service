package board.spring.controller;

import board.spring.dto.request.BoardSaveRequest;
import board.spring.dto.response.BoardDetailResponse;
import board.spring.dto.response.BoardListResponse;
import board.spring.dto.request.BoardUpdateRequest;
import board.spring.service.BoardService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService){ this.boardService = boardService;}

    @PostMapping
    public ResponseEntity<Void> saveBoard(@RequestBody @Valid BoardSaveRequest request) {
        boardService.savePost(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<BoardListResponse> findBoardList() {
        List<BoardListResponse> responseList = boardService.findBoardList();
        return responseList;
    }

    @GetMapping("/search")
    public List<BoardListResponse> findBoardListByTitle(@RequestParam String title) {
        List<BoardListResponse> responseList = boardService.findBoardListByTitle(title);
        return responseList;
    }

    @GetMapping("/member/{memberId}")
    public List<BoardListResponse> findBoardListByEmail(@PathVariable Long memberId) {
        List<BoardListResponse> responseList = boardService.findPostListByEmail(memberId);
        return responseList;
    }

    @GetMapping("/{boardId}")
    public BoardDetailResponse findBoardDetail(@PathVariable Long boardId) {
        return boardService.findDetail(boardId);
    }

    @PutMapping("/{boardId}")
    public ResponseEntity<Void> updateBoard(
            @PathVariable Long boardId,
            @RequestBody BoardUpdateRequest request) {
        boardService.updateBoard(boardId,request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long boardId) {
        boardService.deletePost(boardId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}