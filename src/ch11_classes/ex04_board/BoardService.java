package ch11_classes.ex04_board;

import java.util.List;
import java.util.Scanner;

public class BoardService {
    BoardRepository boardRepository = new BoardRepository();
    Scanner scanner = new Scanner(System.in);
    public void save() {
        System.out.print("제목: ");
        String boardTitle = scanner.next();
        System.out.print("작성자: ");
        String boardWriter = scanner.next();
        System.out.print("비밀번호: ");
        String boardPass = scanner.next();
        System.out.print("내용: ");
        String boardContents = scanner.next();
        BoardDTO boardDTO = new BoardDTO(boardTitle, boardWriter, boardPass, boardContents);
        boolean result = boardRepository.save(boardDTO);
        if (result) {
            System.out.println("글작성 완료");
        } else {
            System.out.println("글작성 실패");
        }
    }

    public void findAll() {
        List<BoardDTO> boardDTOList = boardRepository.findAll();
        System.out.println("id\t" + "title\t" + "writer\t" + "hits\t");
        for (BoardDTO boardDTO: boardDTOList) {
            System.out.println(boardDTO.getId() + "\t" + boardDTO.getBoardTitle() + "\t" +
                    boardDTO.getBoardWriter() + "\t" + boardDTO.getBoardHits() + "\t");
        }
    }

    public void findById() {
        System.out.print("조회 id: ");
        Long id = scanner.nextLong();
        // 1. 조회수를 1 증가
        boolean result = boardRepository.updateHits(id);
        // 2. 상세내용 가져옴
        if (result) {
            BoardDTO boardDTO = boardRepository.findById(id);
            System.out.println("boardDTO = " + boardDTO);
        } else {
            System.out.println("요청하신 게시글은 존재하지 않습니다!");
        }
    }

    public void update() {
        System.out.print("수정할 id: ");
        Long id = scanner.nextLong();
        System.out.print("비밀번호: ");
        String boardPass = scanner.next();
        BoardDTO boardDTO = boardRepository.findById(id);
        // 게시글 있는지 확인
        if (boardDTO != null) {
            // 비밀번호 검증
            if (boardPass.equals(boardDTO.getBoardPass())) {
                // 비밀번호가 맞으면 수정할 제목, 내용 입력받고 수정처리
                System.out.print("수정 제목: ");
                String boardTitle = scanner.next();
                System.out.print("수정 내용: ");
                String boardContents = scanner.next();
                boolean result = boardRepository.update(id, boardTitle, boardContents);
                if (result) {
                    System.out.println("수정 완료");
                } else {
                    System.out.println("수정 실패");
                }
            } else {
                System.out.println("비밀번호가 일치하지 않습니다!");
            }
        } else {
            System.out.println("요청하신 게시글은 존재하지 않습니다!");
        }
    }

    public void delete() {
        System.out.print("수정할 id: ");
        Long id = scanner.nextLong();
        System.out.print("비밀번호: ");
        String boardPass = scanner.next();
        BoardDTO boardDTO = boardRepository.findById(id);
        if (boardDTO != null) {
            if (boardPass.equals(boardDTO.getBoardPass())) {
                boolean result = boardRepository.delete(id);
                if (result) {
                    System.out.println("삭제 완료");
                } else {
                    System.out.println("삭제 실패");
                }
            } else {
                System.out.println("비밀번호가 일치하지 않습니다!");
            }
            System.out.println("요청하신 게시글은 존재하지 않습니다!");
        }
    }
}
