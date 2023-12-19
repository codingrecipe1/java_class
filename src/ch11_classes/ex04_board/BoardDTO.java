package ch11_classes.ex04_board;

public class BoardDTO {
    private Long id;
    private String boardTitle;
    private String boardWriter;
    private String boardPass;
    private String boardContents;
    private int boardHits = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardWriter() {
        return boardWriter;
    }

    public void setBoardWriter(String boardWriter) {
        this.boardWriter = boardWriter;
    }

    public String getBoardPass() {
        return boardPass;
    }

    public void setBoardPass(String boardPass) {
        this.boardPass = boardPass;
    }

    public String getBoardContents() {
        return boardContents;
    }

    public void setBoardContents(String boardContents) {
        this.boardContents = boardContents;
    }

    public int getBoardHits() {
        return boardHits;
    }

    public void setBoardHits(int boardHits) {
        this.boardHits = boardHits;
    }

    public BoardDTO() {

    }

    private static Long idValue = 1L;

    public BoardDTO(String boardTitle, String boardWriter, String boardPass, String boardContents) {
        this.id = idValue++;
        this.boardTitle = boardTitle;
        this.boardWriter = boardWriter;
        this.boardPass = boardPass;
        this.boardContents = boardContents;
        this.boardHits = 0;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "id=" + id +
                ", boardTitle='" + boardTitle + '\'' +
                ", boardWriter='" + boardWriter + '\'' +
                ", boardPass='" + boardPass + '\'' +
                ", boardContents='" + boardContents + '\'' +
                ", boardHits=" + boardHits +
                '}';
    }
}
