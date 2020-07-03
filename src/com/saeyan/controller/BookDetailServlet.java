package com.saeyan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BookDAO;
import com.saeyan.dto.BookVO;

@WebServlet("/bookDetail.do")
public class BookDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int itemid = Integer.parseInt(request.getParameter("itemid"));
		
		BookDAO bDao = BookDAO.getInstance();
		BookVO bVo = bDao.getBook(itemid);
		
		List<BookVO> similarBookList = bDao.selectSimilarBooks(itemid, bVo.getAuthor(), bVo.getCategoryName());
		
		request.setAttribute("bVo", bVo);
		request.setAttribute("similarBookList", similarBookList);
		
		String passages[] = {
				"나에겐 아몬드가 있다. 당신에게도 있다.<br>당신이 가장 소중하게 여기거나 가장 저주하는 누군가도 그것을 가졌다.<br>아무도 그것을 느낄 수는 없다. 그저 그것이 있음을 알고 있을 뿐이다.<br>&emsp;-〈아몬드〉중에서 -",
				"특별한 것과 소중한 것은 다르다.<br>우리의 가족, 친구, 연인이 특별하고 우월한 존재여서 소중한 게 아니라 우리가 마음을 주어 소중해지는 것처럼, 나 자신과 내가 가진 것을 그 자체로 소중하게 여길 수 있어야 한다.<br>그러면 자존감은 채워지기 시작한다.<br>&emsp;-〈애쓰지 않고 편안하게〉중에서 -",
				"새는 알에서 나오려고 투쟁한다.<br>알은 세계이다.<br>태어나려는 자는 하나의 세계를 깨뜨려야 한다.<br>&emsp;-〈데미안〉중에서 -",
				"있는 그대로의 모습으로 만인에게 사랑받을 수는 없다.<br>하지만 역으로 말하면, 있는 그대로의 모습을 받아들인 소수와의 관계는 견고한 것이다.<br>한 번도 실망시키지 않고서는, 나는 누군가와 진실로 가까울 자신이 없다.<br>우리, 마음껏 실망하자. 그리고 자유롭게 도란거리자.<br>&emsp;-〈보통의 언어들〉중에서 -",
				"어쩌면 우린 너무 많은 기적을 당연하게 생각하면서 사는지도 모르겠어.<br>엄마가 딸을 만나고, 가족이 함께 밥을 먹고, 울고 웃는 평범한 일상이 분명 누군가한테는 기적 같은 일일 거야.<br>그저 우리가 눈치채지 못하고 있을 뿐이지.<br>&emsp;-〈세계를 건너 너에게 갈게〉중에서 -",
				"똑같이 터미널에서 일한다 해도 터미널고속의 직원이냐, 파견 근로자냐에 따라 마시는 공기도 달랐다.<br>차량이 내뿜는 매연과 분진은 비정규직인 파견 노동자들이 마시고, 터미널고속 직원들은 신선한 공기를 마신다.<br>정규직은 공기 순환 장치가 달린 사무실에서 근무하고<br>용역인 경비원들은 매연으로 가득한 지하 주차장과 노상에서 일하기 때문이다.<br>&emsp;-〈임계장 이야기〉중에서 -",
				"조국은 언덕 위의 그 향기로운 덤불 속에, 바다 속에,<br>자유로운 고장들과 따뜻한 사랑의 무게 속에 있었다.<br>&emsp;-〈페스트〉중에서 -",
				"여러 조건이 잘 맞으면 이야기는 자연스레 생겨나고 사이를 오가게 된다.<br>“어디, 자네도 얘기 한번 해보게” 한다고 해서 소통이 일어나는 게 결코 아니다.<br>빛과 온도와 습도가 잘 맞으면 흙속의 씨앗들이 너도나도 싹트듯이,<br>편안하고 서로에게 집중할 수 있는 조건이 갖춰지면 이야기꽃이 피어나는 것이다.<br>‘이야기꽃’이라는 표현이 괜히 있는 게 아니구나 싶었다.<br>&emsp;-〈말하기를 말하기〉중에서 -",
				"사연을 아는 사람들은 내게 수십 년 동안 찾아와 위로의 말을 건넸다네.<br>그래도 당신들은 같은 우주 안에 있는 것이라고. 그 사실을 위안 삼으라고.<br>하지만 우리가 빛의 속도로 갈 수조차 없다면, 같은 우주라는 개념이 대체 무슨 의미가 있나?<br>&emsp;-〈우리가 빛의 속도로 갈 수 없다면〉중에서 -",
				"부탁하건대, 언젠가는 내가 당신의 자살을 막은 것을 용서해주면 좋겠다.<br>나는 그 순간 살아야 했고, 당신을 살려야만 내가 계속 살 수 있을 것만 같았다.<br>나는 아직 배에서 내리지 않았다. 우리는 여전히 함께 배를 타고 있다.<br>그것만큼은 오래도록 잊지 않을 것이다.<br>&emsp;-〈죽은 자의 집 청소〉중에서 -"
		};
		
		int num = (int)(Math.random()*10);
		String result = passages[num];
		request.setAttribute("result", result);
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("book/bookDetail.jsp");
		dispatcher.forward(request, response);
	}
}