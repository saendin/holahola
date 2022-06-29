package com.sunjin.app.member;

import java.util.List;
import java.util.Scanner;

import com.sunjin.app.common.LogInSys;
import com.sunjin.app.common.Login;
import com.sunjin.app.rental.RentalDAO;
import com.sunjin.app.rental.RentalInfo;

public class MemberManagement extends LogInSys {
	private Scanner sc = new Scanner(System.in);
	protected MemberDAO mDAO = MemberDAO.getInstance();
	private int roleOut;

	// LogInSys 후 권한에 따라 프로그램 실행
	public int runOut() {
		roleOut = 0;
		// 메뉴에 따라 프로그램 실행 시키도록.
		// 권한이 0일 때 관리자시스템 실행
		boolean role = selectRole();

		while (true) {
			// 메뉴 출력 - 제품 정보 관리/ 제품 재고 관리/ 종료
			menuPrint(role);

			int menuNo = menuSelect();

			if (menuNo == 1) {
				// 회원 정보 수정
				updateInfoP();
			}
			// 주문 내역 - 수정필요
			else if (menuNo == 2) {
//				orderList();
//				orderListInfo();
				orderList();
				
				// 회원 정보 조회
			} else if (menuNo == 5 && role) {
				memberInfo();

				// 전체 회원 조회
			} else if (menuNo == 6 && role) {
				allMemberInfo();

				// 회원삭제
			} else if (menuNo == 7 && role) {
				deleteMember();

				// 회원 탈퇴
			} else if (menuNo == 9) {
				roleOut = deleteMyself();
				if(roleOut == 1) {
					break;
				}
				

				// 뒤로
			} else if (menuNo == 0) {
				break;

				// 입력 오류
			} else {
				showInputError();
			}
		}
		
		return roleOut;
	}

//	private void orderListInfo() {
//		String id = Login.getLogin().getId();
//		List<RentalInfo> list = RentalDAO.getInstance().selectList(id);
//		for (RentalInfo info : list) {
//			System.out.println(info);
//		}
//	}
	
	//수정필요
	private void orderList() {
		String id = Login.getLogin().getId();
		
		RentalInfo info = mDAO.findRent(id);
		
			if (info != null) {
				System.out.println(info);
				System.out.println();
			} else {
				System.out.println("대여 내역이 없습니다 !");
			}
		}

	// 마이페이지 메뉴
	private void menuPrint(boolean check) {
		// 권한에 따라 메뉴를 프린트하기 위한 것
		if (!check) {
			String menu1 = "";
			// 회원[1]권한
			menu1 += "[1] 회원정보수정 | [2] 주문내역 | [9] 회원탈퇴  | [0] 뒤로가기";
			System.out.println();
			System.out.println(
					"======================================      메뉴      ========================================");
			System.out.println();
			System.out.println("                      " + menu1);
			System.out.println();
			System.out.println(
					"=============================================================================================");
		} else {
			String menu2 = "";
			// 관리자[0]권한
			menu2 += "[5] 회원조회 | [6] 전체회원조회 | [7] 회원삭제  | [0] 뒤로가기";
			System.out.println(
					"======================================      관리      ========================================");
			System.out.println();
			System.out.println("                       " + menu2);
			System.out.println();
			System.out.println("=============================================================================================");
		}
	}

	// 1. 회원 정보 수정 - phone
	private void updateInfoP() {
		// 로그인된 아이디 사용
		String member = Login.getLogin().getId();
		System.out.println();
		// 비밀번호 입력받기
		System.out.println("                       " + member + " 님의 비밀번호를 다시 한 번 입력해주세요 !");
		System.out.println();
		String pwd = sc.nextLine();
		System.out.println();
		// 로그인 받은 아이디랑 비번 일치 확인
//		while (true) {
		// 아이디랑 일치여부 확인
		// () 반환값 true일 때 member.Phone번호 업데이트 & DB정보 업데이트
		if (pwd.equals(Login.getLogin().getPwd())) {
			// 업데이트할 전화번호 받기
			System.out.println();
			System.out.println("                                      확인되었습니다 !");
			System.out.println();
			inputUpdatePhone();
//				mDAO.updateInfoP(member);
		} else {
			System.out.println();
			System.out.println("                                   잘못된 비밀번호입니다.");
			System.out.println("                                   다시한번 확인해주세요!");
			System.out.println();
			return;
		}
	}
//	}

	// --
	private int inputUpdatePhone() {
		System.out.println();
		System.out.println("                                 기존 전화번호 -> 0" + Login.getLogin().getPhone()); // 멤버의 폰번호를 가져와서 보여줌
		System.out.println();
		System.out.println("                           수정할 전화번호를 입력해주세요 (' - ' 없이 입력)");
		System.out.println("                               (수정을 원하지 않을 경우 [0] 입력)");
		System.out.println();
		int phoneNum = Integer.parseInt(sc.nextLine());
		// 입력값 0 아닐 때 -> 변경여부 확인
		// yes -> 입력한 폰넘버 set해주기
		// No -> 기존번호값 리턴
		if (phoneNum != 0) {
			System.out.println();
			System.out.println("                                아래의 번호로 변경하시겠습니까?");
			System.out.println();
			System.out.print("                                        0");
			System.out.println(phoneNum);
			System.out.println();

			int answer = YOrN();
			if (answer == 1) {
				Login.getLogin().setPhone(phoneNum);
				mDAO.updateInfoP(Login.getLogin());
				System.out.println();
				System.out.println("                                  정상적으로 수정되었습니다 !");
				System.out.println();
			} else if (answer == 0) {
				
				System.out.println();
				System.out.println("                                   변경이 취소되었습니다 !");
				System.out.println();

			}
		} // [0]입력 -> 기존 휴대폰번호 반환

		return phoneNum;
	}

	private int YOrN() {
		System.out.println();
		System.out.println("                                  [1] 네    [0] 돌아가기");
		System.out.println();
		return Integer.parseInt(sc.nextLine());
	}

	// 2. 대여내역 조회

	// 9. 회원탈퇴
	private int deleteMyself() {
		
		// 삭제할 아이디 = 로그인된 아이디
		String id = Login.getLogin().getId();
		// 멤버테이블에서 아이디 조회
		Member member = mDAO.findId(id);

		if (member == null) {
			// 아이디 없을경우 다음을 반환
			System.out.println();
			System.out.println("                                  존재하지 않는 회원입니다 !");
			System.out.println();
			return 0;
		}
		int answer = YesOrNot();
		if (answer == 1) {
			// yes(1) = 삭제 진행
			System.out.println();
			System.out.println("                              탈퇴처리가 정상적으로 완료되었습니다 !");
			System.out.println();
			System.out.println("                                    다음에 또 만나요 :)!");
			System.out.println();
			mDAO.delete(id);
			return 1;
		} else if (answer == 0) {
			System.out.println();
			System.out.println("                                  돌아오신 것을 환영합니다 !");
			System.out.println("                      이제 다시 럭셔리 모먼트의 많은 혜택을 누리실 수 있어요!");
			System.out.println();
			return 0;
		}
		return 0;
	}

	// -- 탈퇴 재확인
	private int YesOrNot() {
		System.out.println();
		System.out.println("                      탈퇴하시면 더 이상 럭셔리모먼트의 혜탁을 받을 수 없습니다.");
		System.out.println("                                   그래도 계속 하시겠습니까?");
		System.out.println();
		System.out.println("                                [1] 네        [0] 돌아가기");
		System.out.println();
		System.out.println();
		return Integer.parseInt(sc.nextLine());
	}

	//////////////////////////// 관리자////////////////////////////

	// 5. 선택 회원 조회
	private void memberInfo() {
		String id = inputId();
		Member member = mDAO.findId(id);
		if (member != null) {
			System.out.println(member);
		} else {
			System.out.println();
			System.out.println();
			System.out.println("                                 존재하지 않는 회원입니다 !");
			System.out.println();
		}
	}

	// --
	private String inputId() {
		System.out.print("검색할 회원의 아이디를 입력하세요 > ");
		return sc.nextLine();
	}

	// 6. 전체회원 조회
	private void allMemberInfo() {
		List<Member> list = mDAO.selectAll();
		for (Member member : list) {
			System.out.println(member);
		}
	}

	// 7. 회원 삭제
	private void deleteMember() {
		// 삭제할 아이디 입력
		String id = inputDeleteId();
		// 멤버테이블에서 아이디 조회
		Member member = mDAO.findId(id);

		if (member == null) {
			// 아이디 없을경우 다음을 반환
			System.out.println();
			System.out.println("                                 존재하지 않는 회원입니다 !");
			System.out.println();
			return;
		}
		int answer = YesOrNo();
		if (answer == 1) {
			// yes(1) = 삭제
			System.out.println();
			System.out.println("                                  삭제가 완료되었습니다 !");
			System.out.println();
			mDAO.delete(id);
		} else if (answer == 0) {
			System.out.println();
			System.out.println("                                  삭제가 취소되었습니다 !");
			System.out.println();
			return;
		}
	}

	private String inputDeleteId() {
		System.out.println();
		System.out.print("                            삭제할 회원의 아이디를 입력하세요 > ");
		return sc.nextLine();
	}

	private int YesOrNo() {
		System.out.println();
		System.out.println("                             삭제된 회원 정보는 복구하실 수 없습니다.");
		System.out.println("                                 그래도 정말 삭제 하시겠습니까 ?");
		System.out.println();
		System.out.println("                                  [1] 네      [0] 돌아가기");
		System.out.println();
		return Integer.parseInt(sc.nextLine());
	}
}
