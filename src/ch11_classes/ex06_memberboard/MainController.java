package ch11_classes.ex06_memberboard;

import ch11_classes.ex06_memberboard.common.CommonVariables;
import ch11_classes.ex06_memberboard.service.BoardService;
import ch11_classes.ex06_memberboard.service.MemberService;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int selectNo = 0;
        BoardService boardService = new BoardService();
        MemberService memberService = new MemberService();
        while (run) {
            System.out.println("====== 회원관리 ======");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("1.회원가입 | 2.로그인 | 3.회원목록 | 4.회원수정 | 5.회원탈퇴 | 6.로그아웃 | 7.게시판메뉴 | 0.종료");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.print("선택>  ");
            selectNo = scanner.nextInt();
            if (selectNo == 1) {
                System.out.println("회원가입 메뉴");
                memberService.save();
            } else if (selectNo == 2) {
                System.out.println("로그인 메뉴");
                memberService.login();
            } else if (selectNo == 3) {
                System.out.println("회원목록 메뉴");
                memberService.findAll();
            } else if (selectNo == 4) {
                System.out.println("회원수정 메뉴");
                memberService.update();
            } else if (selectNo == 5) {
                System.out.println("회원탈퇴 메뉴");
                memberService.delete();
            } else if (selectNo == 6) {
                System.out.println("로그아웃 메뉴");
                memberService.logout();
            } else if (selectNo == 0) {
                System.out.println("종료");
            } else if (selectNo == 7) {
                boolean boardRun = true;
                while (boardRun) {
                    if (CommonVariables.loginEmail != null) {
                        System.out.println("====== 게시판 ======");
                        System.out.println("-----------------------------------------------------------------------------------------");
                        System.out.println("1.글작성 | 2.글목록 | 3.글조회 | 4.글수정 | 5.글삭제 | 6.검색 | 99.sample | 0.메인메뉴");
                        System.out.println("-----------------------------------------------------------------------------------------");
                        System.out.print("선택> ");
                        selectNo = scanner.nextInt();
                        if (selectNo == 1) {
                            boardService.save();
                        } else if (selectNo == 2) {
                            boardService.findAll();
                        } else if (selectNo == 3) {
                            boardService.findById();
                        } else if (selectNo == 4) {
                            boardService.update();
                        } else if (selectNo == 5) {
                            boardService.delete();
                        } else if (selectNo == 6) {
                            boardService.search();
                        } else if (selectNo == 99) {
                            boardService.testData();
                        } else if (selectNo == 0) {
                            boardRun = false;
                        } else {
                            System.out.println("다시입력");
                        }
                        System.out.println();
                    } else {
                        System.out.println("회원전용 메뉴입니다.");
                        boardRun = false;
                    }
                }
            }
        }
        System.out.println("프로그램 종료");
    }
}
