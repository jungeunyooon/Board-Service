package board.spring.dto.response;

import board.spring.domain.Board;

public class BoardListResponse {
    private String title;
    private String content;

    public BoardListResponse(String title, String content){
        this.title = title;
        this.content = content;
    }
    public static BoardListResponse from(Board board){
        return new BoardListResponse(board.getTitle(), board.getContent());
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}

