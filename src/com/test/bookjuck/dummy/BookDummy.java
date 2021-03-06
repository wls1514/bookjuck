package com.test.bookjuck.dummy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import com.test.bookjuck.DBUtil;

public class BookDummy {

	public static void main(String[] args) {
		
		//도서더미
		//소분류별 20개씩 (국내-소설-외국소설 제외)
		
		//작가 1~15 (랜덤)
		//(소)카테고리번호 1~120 (랜덤)
		//제목 10개 (만들기)
		//출판사 10개 (만들기)
		//가격 10개 (만들기)
		//판매가 -> 가격 * 0.9
		//출판일 10개 (만들기) -> 2000년 이전
		//줄거리 10개 (만들기)
		//isbn 13자리 HashSet
		//한줄카피 10개 (만들기)
		//이미지 10개 (해리포터 가져오기)
		//페이지 200~500(랜덤)
		//목차 10개 (만들기)
		
		HashSet<String> isbn = new HashSet<String>();
		
		//목차 10개
		String[] contents = {
				String.format("Chapter 1 어느 날 나무가 내 곁으로 왔다\r\n" + 
				"삼천 년을 사는 나무에게 배운 것 - 주목나무\r\n" + 
				"내 허기를 달래 준 고마운 나무 - 이팝나무\r\n" + 
				"세상의 모든 아버지들에게 바칩니다 - 소나무\r\n" + 
				"마흔 살 된 누군가에게 주고 싶은 나무 - 오리나무\r\n" + 
				"삶이 그대를 속일지라도 - 아까시나무\r\n" + 
				"밤새워 연애편지를 썼었습니다 - 자작나무\r\n" + 
				"박수 칠 때 떠날 것 - 동백나무\r\n" + 
				"지울 수 없는 과거를 대하는 법 - 조팝나무\r\n" + 
				"어머니 품이 그리울 때 - 느티나무\r\n" + 
				"사랑과 상처의 함수 관계 - 등나무\r\n" + 
				"보기만 해도 웃음이 나는 나무 - 생강나무\r\n" + 
				"밉지만 미워할 수 없는 아이처럼 - 밤나무\r\n" + 
				"그는 갔지만 그의 마음은 남았습니다 - 목련\r\n" + 
				"아무도 알아주지 않는 길이라 해도 - 회양목\r\n" + 
				"\r\n" + 
				"나무에게 부치는 편지 : 나무야, 아프지 마라\r\n" + 
				"\r\n" + 
				"Chapter 2 나무가 나에게 가르쳐 준 것들\r\n" + 
				"결국 사람의 마음을 움직이는 것은 - 모과나무좀 바보 같으면 어떻습니까? - 노간주나무\r\n" + 
				"첫사랑이 내게 남겨 준 것 - 라일락\r\n" + 
				"받아들이는 용기를 가르쳐 준 나무 - 대나무\r\n" + 
				"나도 누군가에게 그런 사람이었음 좋겠다 - 서어나무\r\n" + 
				"얻기 위해선 잃어야 할 것도 있는 법 - 은행나무\r\n" + 
				"사위 사랑이 이러하기를 - 사위질빵\r\n" + 
				"씩씩함에 대하여 - 개나리\r\n" + 
				"더불어 산다는 것의 의미 - 전나무\r\n" + 
				"결혼을 앞둔 사람들에게 해 주고 싶은 말 - 자귀나무\r\n" + 
				"회화나무 앞에서 소원을 빌어 봅니다 - 회화나무\r\n" + 
				"\r\n" + 
				"나무가 나에게 부쳐 온 편지 : 친구야, 부탁이 하나 있어\r\n" + 
				"\r\n" + 
				"Chapter 3 나는 나무처럼 살고 싶다\r\n" + 
				"사랑한다면 ‘연리지’처럼\r\n" + 
				"기다림의 미학\r\n" + 
				"죽음을 받아들이는 태도\r\n" + 
				"함께 있되 거리를 두라\r\n" + 
				"휴식이 필요한 순간\r\n" + 
				"버려야만 더 큰 것을 얻는다\r\n" + 
				"나무에게서 배운 육아의 지혜\r\n" + 
				"나무에 대한 예의\r\n" + 
				"보잘것없는 나무들이 아름다운 이유\r\n" + 
				"어떻게 살 것인가")
				, String.format("[1장] 쓸데없어 보이는 것의 쓸모\r\n" + 
						"숨겨진 보물을 찾아 떠나는 탐험\r\n" + 
						"기록이 아닌 사람을 만나는 일\r\n" + 
						"새날을 꿈꾸게 만드는 실체 있는 희망\r\n" + 
						"품위 있는 삶을 만드는 선택의 힘\r\n" + 
						"역사의 구경꾼으로 남지 않기 위하여\r\n" + 
						"\r\n" + 
						"[2장] 역사가 내게 가르쳐준 것들\r\n" + 
						"혁신 : 약소국인 신라가 삼국통일의 주인공이 되기까지\r\n" + 
						"성찰 : 태양의 나라 잉카제국은 왜 멸망했는가\r\n" + 
						"창조 : 세상을 바꾸는 생각의 조건\r\n" + 
						"협상 : 하나를 내어주고 둘을 얻는 협상의 달인들\r\n" + 
						"공감 : 왜 할머니, 할아버지는 태극기를 들고 광장으로 나왔을까\r\n" + 
						"합리 : 체면과 실속 중 무엇을 챙겨야 할까\r\n" + 
						"소통 : 메시지를 효과적으로 전달하는 법\r\n" + 
						"\r\n" + 
						"[3장] 한 번의 인생, 어떻게 살 것인가\r\n" + 
						"정도전 : 억압으로부터 자유로워지려면\r\n" + 
						"김육 : 삶을 던진다는 것의 의미\r\n" + 
						"장보고 : 바다 너머를 상상하는 힘\r\n" + 
						"박상진 : 꿈은 명사가 아니라 동사여야 한다\r\n" + 
						"이회영 : 시대의 과제를 마주하는 자세\r\n" + 
						"\r\n" + 
						"[4장] 인생의 답을 찾기 위해 노력하는 사람들에게\r\n" + 
						"각자의 삶에는 자신만의 궤적이 필요하다\r\n" + 
						"역사의 흐름 속에서 현재를 바라본다면\r\n" + 
						"지금 나의 온도는 적정한가\r\n" + 
						"시민이라는 말의 무게\r\n" + 
						"오늘을 잘살기 위해 필요한 것")
				, String.format("1부. 예정된 죽음 앞에서\r\n" + 
								"너무 열심히 산 자의 분노 / 내 돈 2억 갚아라 / 특별하고 위대한 마지막 / 혈연이라는 굴레 / 사후 뇌 기증 / 저는 항암치료 안 받을래요 / 10년은 더 살아야 / 대화가 필요해 / 믿을 수 없는 죽음 / 임종의 지연\r\n" + 
								"\r\n" + 
								"2부. 그럼에도 산다는 것은\r\n" + 
								"인생 리셋 / 기적 / 학교에서 잘렸어요 / 잔인한 생 / 아이의 신발 / 오늘도 공무원 시험을 준비합니다 / 요구트르 아저씨 / 말기 암 환자의 결혼 / 내 목숨은 내 것이 아니다\r\n" + 
								"\r\n" + 
								"3부. 의사라는 업\r\n" + 
								"별과 별 사이: 600대 1의 관계 / 누군가를 이해한다는 것 / 눈을 마주치지 않는 사람들 / 파비우스 막시무스 / 너무 늦게 이야기해주는 것 아닌가요 / 3월의 신부 / 윤리적인 인간 / 이기심과 이타심\r\n" + 
								"\r\n" + 
								"4부. 생사의 경계에서\r\n" + 
								"각자도생, 아는 사람을 찾아라 / 최선을 다하는 것이 최선이었을까 / 존엄한 죽음을 위해서: 연명의료 결정법에 대하여 / 울 수 있는 권리 / 죽음을 기다리는 시간 / 마지막 뒷모습")
				, String.format("1. 대학 보내는 공장\r\n" + 
										"\r\n" + 
										"2. 청년기 여성에게 소셜미디어란\r\n" + 
										"\r\n" + 
										"3. 살 이야기 좀 할까요?\r\n" + 
										"\r\n" + 
										"4. 자기 의심 극복하고 성별 자신감 격차 줄이기\r\n" + 
										"\r\n" + 
										"5. 생각의 러닝머신 달리기\r\n" + 
										"\r\n" + 
										"6. 자기 비난 대신 자기 자비를\r\n" + 
										"\r\n" + 
										"7. 애쓰지 않아도 완벽한 듯, 스트레스 올림픽\r\n" + 
										"\r\n" + 
										"8. 컨트롤+알트+딜리트, 진로 바꾸기의 장점\r\n" + 
										"\r\n" + 
										"9. 우리에게 없는 건 아이들에게도 줄 수 없다\r\n" + 
										"\r\n" + 
										"10. 졸업반의 좌절, 대학 이후의 삶")
				, String.format("벌새의 습격\r\n" + 
												"적당히 수상쩍은 신입사원\r\n" + 
												"파투산\r\n" + 
												"대충 존재하는 남자\r\n" + 
												"나비와 궤도 엘리베이터\r\n" + 
												"인간 미끼 사용법\r\n" + 
												"첫 번째 점검\r\n" + 
												"초록 마녀와 데이트\r\n" + 
												"“당신은 늘 그랬지. 내가 아니라고 그래도 늘 그랬어.”\r\n" + 
												"유령의 흐릿한 발자국\r\n" + 
												"사라진 나비 그림이 있는 곳\r\n" + 
												"수호천사의 방문\r\n" + 
												"(아마도) 내가 사랑하는 사람\r\n" + 
												"앞으로 해야 할 일\r\n" + 
												"요정의 날개 밑\r\n" + 
												"투명한 짐승들의 전쟁\r\n" + 
												"너무 늦게 기억난 이름\r\n" + 
												"내가 죽인 사람들\r\n" + 
												"실종\r\n" + 
												"다른 사람의 죄\r\n" + 
												"두 번째 점검\r\n" + 
												"파투산으로 돌아가다\r\n" + 
												"‘뜻밖의 범인’\r\n" + 
												"깨워야 할 사람\r\n" + 
												"누군가는 밑에서 할 일이 있다\r\n" + 
												"평형추\r\n" + 
												"대체로 그럴싸한 거짓말\r\n" + 
												"그러면 우리도 땅 위에 남아 있으리라")
				, String.format("첫 번째 감정, 공포\r\n" + 
														"두 번째 감정, 분노\r\n" + 
														"세 번째 감정, 기쁨\r\n" + 
														"네 번째 감정, 자신감\r\n" + 
														"다섯 번째 감정, 질투")
				, String.format("서론: 미로 속으로\r\n" + 
																"\r\n" + 
																"1장 길 찾기: 넌 네가 뭐라고 생각하니?\r\n" + 
																"2장 이중성: 지킬의 손, 하이드의 손, 그리고 모호한 이중성\r\n" + 
																"3장 헌신: 위대한 펜의 신\r\n" + 
																"4장 유혹: 푸로스퍼로, 오즈의 마법사, 메피스토와 그 무리들\r\n" + 
																"5장 성찬식: 무명인에서 무명인으로\r\n" + 
																"6장 하강: 죽은 자와 협상하기")
				, String.format("1장_ 유리멘탈을 극복하는 연습\r\n" + 
																		"\r\n" + 
																		"-다른 사람들의 평가에 초연한 사람들의 비밀\r\n" + 
																		"-습관처럼 나쁜 쪽으로만 생각이 흐른다면\r\n" + 
																		"-함부로 단정 짓는 말들에 상처받는다면\r\n" + 
																		"-부서진 멘탈을 금세 회복하는 방법\r\n" + 
																		"-조언을 들으면 왜 기분이 나쁠까\r\n" + 
																		"-‘지금 이 순간’을 살면 달라지는 것들\r\n" + 
																		"-현실과 싸우면 나만 힘들어진다\r\n" + 
																		"\r\n" + 
																		"2장_ 인간관계가 너무 힘든 유리멘탈에게\r\n" + 
																		"\r\n" + 
																		"-사람 때문에 너덜너덜해진 멘탈 관리법\r\n" + 
																		"-내 의사를 분명히 하면 달라지는 것들\r\n" + 
																		"-꼼짝없이 당하고 있다는 느낌이 들 때\r\n" + 
																		"-남을 변화시키려는 노력이 헛수고인 이유\r\n" + 
																		"-상대의 공격을 정면에서 받지 않는 기술\r\n" + 
																		"-단단한 멘탈을 만드는 주문\r\n" + 
																		"-무례한 지적질에는 어떻게 반응해야 할까\r\n" + 
																		"\r\n" + 
																		"3장_ 깨진 마음 회복시키기\r\n" + 
																		"\r\n" + 
																		"-터널에서 빠져나오기 위한 ‘슬픔의 프로세스’\r\n" + 
																		"-상실감에 대처하는 인간의 자세\r\n" + 
																		"-소중한 친구에게 해주는 말을 자신에게도\r\n" + 
																		"-나의 미숙함을 받아들이는 법\r\n" + 
																		"-현명하게 체념하라\r\n" + 
																		"-그 무엇보다 중요한 것, 마음의 평화\r\n" + 
																		"\r\n" + 
																		"4장_ 건강한 멘탈은 건강한 몸에서 온다\r\n" + 
																		"\r\n" + 
																		"-남에게 잘 보이려고 하면 누구든 피곤해진다\r\n" + 
																		"-오늘부터 편안하게 잠드는 방법\r\n" + 
																		"-예정대로 안 될 때는 그냥 쉰다\r\n" + 
																		"-습관적으로 자신을 다그치는 사람들에게\r\n" + 
																		"-나를 지키는 사람은 나밖에 없다\r\n" + 
																		"\r\n" + 
																		"5장_ 불안을 잠재우고 단단한 마음으로\r\n" + 
																		"\r\n" + 
																		"불안한 감정의 쓸모\r\n" + 
																		"알지 못하기 때문에 불안한 것이다\r\n" + 
																		"인생이 가뿐해지는 4가지 마음의 기술\r\n" + 
																		"나만 뒤처지는 것 같아 조급해질 때\r\n" + 
																		"회사에서 지나치게 압박을 느낀다면\r\n" + 
																		"걱정이 사라지는 간단한 훈련\r\n" + 
																		"앞날을 걱정한다고 결과가 좋아지지는 않는다\r\n" + 
																		"\r\n" + 
																		"6장_ 툭하면 외로워지는 사람들을 위한 심리 처방\r\n" + 
																		"\r\n" + 
																		"-외로움은 어디에서 찾아오는가?\r\n" + 
																		"-인생에서 아무 의미도 찾을 수 없을 때\r\n" + 
																		"-혼자서 보내는 시간을 기분 좋게 즐기는 방법\r\n" + 
																		"-왠지 마음이 가득 차오르는 매일의 습관\r\n" + 
																		"-어떤 사람을 가까이 두어야 할까\r\n" + 
																		"-인간은 본래 강하고 유연한 존재다")
				, String.format("Part1 마음이 낸 길\r\n" + 
																				"친절한 사람과의 소통\r\n" + 
																				"유쾌한 오해\r\n" + 
																				"수많은 믿음의 교감\r\n" + 
																				"사십 대의 비 오는 날\r\n" + 
																				"집 없는 아이\r\n" + 
																				"보통 사람\r\n" + 
																				"\r\n" + 
																				"Part2 꿈을 꿀 희망\r\n" + 
																				"꿈\r\n" + 
																				"언덕방은 내 방\r\n" + 
																				"이멜다의 구두\r\n" + 
																				"천사의 선물\r\n" + 
																				"넉넉하다는 말의 소중함\r\n" + 
																				"나는 나쁜 사람일까? 좋은 사람일까?\r\n" + 
																				"\r\n" + 
																				"Part3 무심한 듯 명랑한 속삭임\r\n" + 
																				"다 지나간다\r\n" + 
																				"아름다운 것은 무엇을 남길까\r\n" + 
																				"나는 누구일까\r\n" + 
																				"생각을 바꾸니\r\n" + 
																				"행복하게 사는 법\r\n" + 
																				"\r\n" + 
																				"Part4 사랑의 행로\r\n" + 
																				"민들레꽃을 선물 받은 날\r\n" + 
																				"사랑을 무게로 안 느끼게\r\n" + 
																				"할머니와 베보자기\r\n" + 
																				"달구경\r\n" + 
																				"사랑의 입김\r\n" + 
																				"내 기억의 창고\r\n" + 
																				"새해 소망\r\n" + 
																				"\r\n" + 
																				"Part5 환하고도 슬픈 얼굴\r\n" + 
																				"성차별을 주제로 한 자서전\r\n" + 
																				"뛰어난 이야기꾼이고 싶다\r\n" + 
																				"중년 여인의 허기증\r\n" + 
																				"코 고는 소리를 들으며\r\n" + 
																				"나의 문학과 고향의 의미\r\n" + 
																				"\r\n" + 
																				"Part6 이왕이면 해피엔드\r\n" + 
																				"잃어버린 여행가방\r\n" + 
																				"시간은 신이었을까\r\n" + 
																				"내 식의 귀향\r\n" + 
																				"때로는 죽음도 희망이 된다\r\n" + 
																				"마음 붙일 곳\r\n" + 
																				"그때가 가을이었으면")
				, String.format("CHAPTER 1 오두환의 광고 철학\r\n" + 
																						"01 불변의 광고 이론, 광고의 8원칙\r\n" + 
																						"02 매출 하락은 반드시 광고의 문제다!\r\n" + 
																						"03 광고 회사는 언제나 예스맨이다\r\n" + 
																						"04 광고비를 벌어 주는 광고?\r\n" + 
																						"05 소비 습관의 저격수가 되어라!\r\n" + 
																						"06 우왕좌왕하지 말고, 원칙만 지켜라!\r\n" + 
																						"07 내가 원할 때, 고객들도 간절히 원한다\r\n" + 
																						"08 5%%가 되려면, 95%%와 다른 길을 가라\r\n" + 
																						"\r\n" + 
																						"CHAPTER 2 광고란 무엇인가\r\n" + 
																						"01 광고(廣告)? 이젠 광고(光高)!\r\n" + 
																						"02 기본을 지키는 광고\r\n" + 
																						"03 광고와 매출의 관계\r\n" + 
																						"\r\n" + 
																						"CHAPTER 3 광고의 8원칙\r\n" + 
																						"01 그것을 바라보게 하라!\r\n" + 
																						"02 그것에 다가오게 하라!\r\n" + 
																						"03 그것을 생각하게 하라!\r\n" + 
																						"04 그것이 필요하게 하라!\r\n" + 
																						"05 그것을 소망하게 하라!\r\n" + 
																						"06 그것을 구매하게 하라!\r\n" + 
																						"07 그것에 만족하게 하라!\r\n" + 
																						"08 그것을 전파하게 하라!\r\n" + 
																						"\r\n" + 
																						"CHAPTER 4 실전 광고? 실속 광고!\r\n" + 
																						"01 편리한 시대가 주는 혜택을 이용하라!\r\n" + 
																						"02 무조건 가성비를 높여라!\r\n" + 
																						"03 친숙한 정보를 활용하라!\r\n" + 
																						"04 팬을 모은 다음, 풀어 둬라!\r\n" + 
																						"05 즐거운 대화로 소통하기!\r\n" + 
																						"06 숨은그림찾기를 넘어서라!\r\n" + 
																						"07 신뢰의 메커니즘을 읽어라!\r\n" + 
																						"08 재미있는? 진심이 담긴!\r\n" + 
																						"09 계속 눈에 밟히는 브랜드!\r\n" + 
																						"\r\n" + 
																						"CHAPTER 5 제대로 광고하는 4가지 비법\r\n" + 
																						"01 대행사에 맡기는 비법\r\n" + 
																						"02 실행사에 맡기는 비법\r\n" + 
																						"03 직원에게 맡기는 비법\r\n" + 
																						"04 자신에게 맡기는 비법\r\n" + 
																						"\r\n" + 
																						"CHAPTER 6 같지만, 확실히 다른 기법\r\n" + 
																						"01 광고와 마케팅의 차이\r\n" + 
																						"02 같이 알아 두면 좋은 오케팅") };
		
		//이미지 10개
		String[] image = { "해리포터와 마법사의 돌 1.png", "해리포터와 마법사의 돌 2.png", "해리포터와 불사조 기사단 1.png", "해리포터와 불사조 기사단 2.png", "해리포터와 아즈카반의 죄수 1.png", "해리포터와 아즈카반의 죄수 2.png", "해리포터와 죽음의 성물 1.png", "해리포터와 죽음의 성물 2.png", "해리포터와 혼혈 왕자 2.png", "해리포터와 혼혈 왕자 1.png" };
		
		//한줄카피 10개
		String[] copy = { "나만의 음악이 시작되는 순간", "세계는 왜 분노하는가", "엔딩 그 다음, 새로운 이야기가 열린다", "다섯 가지 감정 이야기", "마거릿 애트우드의 글쓰기", "21세기 말모이의 재탄생", "채식 지향인의 섭식 에세이", "소녀를 위한 성장 심리학", "봉제인형 살인사건 시리즈!", "목숨을 건 승부수" };
		
		//제목 10개
		String[] title = { "네 명의 완벽주의자", "꼭두각시 살인사건", "병명은 가족", "글쓰기에 대하여", "내 마음이 왜 이럴까?", "말모이, 다시 쓰는 우리말 사전", "바퀴 달린 것에 투자하라", "평형추", "소녀는 어떻게 어른이 되는가", "섭식일기" };
		
		//출판사 10개
		String[] publisher = { "알마", "오월의봄", "자음과모음", "길벗", "흐름출판", "베가북스", "다산초당", "사계절", "창비", "메이븐" };
		
		//가격 10개
		int[] price = { 11700, 12600, 15300, 14400, 13000, 17000, 11500, 21000, 19500, 11900 };
		
		//출판일 10개
		String[] pubDate = { "2000-02-05", "2000-06-25", "2000-01-22", "2000-04-22", "2000-10-11", "1999-02-02", "1999-07-25", "1999-11-23", "1998-01-30", "1998-02-20" };
		
		//줄거리 10개
		String[] summary = { String.format("‘미끼’라는 단어가 새겨진 피해자,\r\n" + 
				"‘꼭두각시’라는 단어가 새겨진 가해자!\r\n" + 
				"\r\n" + 
				"에밀리 백스터 경감은 봉제인형 살인사건과 그녀의 친구 윌리엄 ‘울프’ 폭스가 실종된 충격으로부터 벗어나지 못하고 있었다. 그래서 또 다른 잔인한 사건에 휘말리고 싶지 않았지만, 봉제인형 살인사건의 모방범죄가 발생하는 바람에 뉴욕으로 파견된다. 뉴욕 브루클린 다리에는 한 남성의 시체가 뒤틀린 자세로 매달려 있고 가슴에는 ‘미끼’라는 단어가 깊이 새겨져 있었다. 반면, 자살한 가해자의 가슴에는 ‘꼭두각시’라는 단어가 새겨져 있었다. 대서양을 사이에 두고 영국과 미국에서 발생한 끔찍한 연쇄 살인사건을 막기 위해 백스터는 지난 수년 간 자신을 사로잡았던 슬픔과 두려움을 극복해야만 하는데"), String.format("EBS [세상에 나쁜 개는 없다] 출연 반려견 전문가 설채현이 쓴 강아지 마음 설명서\r\n" + 
						"우리 강아지는 지금 무슨 말을 하고 싶은 걸까?\r\n" + 
						"나도 몰랐던 우리 강아지의 속마음을 들여다보다!\r\n" + 
						"\r\n" + 
						"『설채현 선생님의 강아지 마음 사전』은 강아지가 가족에게 무슨 말을 전하고 싶은 건지, 왜 이런 행동을 하는지 강아지의 언어와 속마음을 샅샅이 탐구하는 책이다. 설채현 수의사는 EBS 방송 [세상에 나쁜 개는 없다]에서 강아지를 섬세하게 관찰하고 훈련하는 모습을 통해 강아지를 이해하고 강아지와 친해지는 비결을 전수하고 있다. 그런데 이번 책을 통해서는 강아지와 친해지고 싶은 어린이들을 위해 강아지에 대해 꼭 알아야 할 정보나 강아지를 대하는 마음가짐 등을 차근차근 알려 주고 있다. 실제로 반려견을 키우면서 수의사의 꿈을 키워 온 설채현은, 더 많은 사람이 강아지와 행복하게 소통했으면 하는 마음으로 이 책을 썼다. 특히 강아지와 친해지고 싶지만 방법이 서툴렀던 어린이들이 이 책을 읽으면서 강아지의 심리나 행동을 쉽고 재밌게 이해하길 바라는 마음을 담았다."), String.format("식탐과 밀당하는 채식 지향인의\r\n" + 
								"본격 섭식 에세이\r\n" + 
								"나를 사랑하고 타자를 존중하는 미각의 여정\r\n" + 
								"\r\n" + 
								"‘섭식’만큼이나 종을 막론하는 활동이 또 있을까. 먹는 것의 종류는 제각기 다를 지라도, 생명체라면 응당 무언가를 섭취해야만 생을 유지할 수 있으니. 그러나 섭식은 언제나 ‘살생’을 동반한다. 그중 가장 끔찍한 형태는 아마 언제 어디서든 양껏 ‘고기’를 먹겠다며 수많은 동물들을 학살하는 대규모 축산업일 것이다. 인류세 그 어디에도 없었던 광경을 지금 우리가 보고 있는 셈이다. 인간의 손이 닿으면 그곳이 어디든 남아나지 못하는 세상. 언제나 그렇듯 시작은 ‘죄책감’이지만, 거기 머무를 수만은 없다. 이 거대한 폭력의 고리를 조금이나마 끊어보려 식탁 위 ‘자그마한 저항’을 실천하기로 한다. 무엇보다 그건 자기 자신을 더 사랑하는 방법이기도 했다."), String.format("기자 출신 정신과 의사의 마음 관찰기. 이 책은 엄마에게 인정받고 싶었던 마음이 우울증으로, 아내를 향한 헌신이 공황장애로, 아버지의 알코올의존이 딸의 약물의존으로 이어지는 과정 등, 정신질환으로 고통받는 사람들의 아픈 마음 한 편에 가족이 연결되어 있음을 보여준다. 또한 조현병이나 치매 환자의 삶처럼 우리가 잘 모르는 병 속에서 환자와 보호자는 실제로 어떻게 살아가는지를 말해준다.\r\n" + 
								"\r\n" + 
								"이 책에는 정신과 의사가 환자들과 비슷한 고통을 겪으면서 변해가는 과정도 담겨 있다. 또한 정신질환으로 인한 사망률이 점점 높아지는 현실을 지적하며, 만들어진 병으로 치부할 수 없는 현실을 드러낸다. 은연중에 정신질환을 묻지 마 범죄의 시작이나, 의지의 문제로 생각했던 독자들은 페이지를 빠르게 넘기는 동안 정신질환을 새롭게 생각하게 될 것이다."), String.format("“수학이 재미있어야 공부를 잘하는 게 아닙니다.\r\n" + 
										"공부를 잘해야 수학이 재미있어집니다!”\r\n" + 
										"성적이 안 올라 답답했던 수학 공부,\r\n" + 
										"‘무너지지 않는 공부법’으로 이제는 웃을 수 있다!\r\n" + 
										"\r\n" + 
										"대치동 사교육에 대한 부모들의 마음은 둘로 나뉜다. ‘아이들에게 공부를 너무 빡세게 시켜서 썩 마음에 들지 않는다’는 마음과, ‘내신과 대학 입시를 생각하면 대치동으로 학원을 보내는 게 나은가?’ 하는 마음이다. 꼭 대치동으로 학원을 보내지 않더라도 아이가 커가고 성적이 중요해질수록 ‘대치동에서는 어떻게 가르치지?’ 하는 생각을 한 번쯤은 하게 된다. 특히 수학은 아이들이 어려워하는 데다 어려서부터 공부를 해도 성적 올리기가 힘든 과목이어서 부모들은 학습 성과가 확실한 대치동의 공부법에 많은 관심을 갖는다. 어떤 점이 대치동을 학습 성과 좋은 사교육의 중심지로 생각하게 만든 것일까? 대치동에서 공부하면 정말 원하는 성과를 얻을 수 있을까?"), String.format("얼어붙은 마음을 녹이는 강력한 목소리\r\n" + 
												"볼로냐 라가치 상 수상 작가 강경수 신작\r\n" + 
												"\r\n" + 
												"『거짓말 같은 이야기』 『꽃을 선물할게』 ‘코드네임’ 시리즈 등을 펴내며 수많은 어린이 독자를 사로잡은 매력적인 이야기꾼 강경수의 신작 그림책이 출간되었다. 일상의 한 조각을 통해 삶의 진실을 숙고하게 하고 세상을 새롭게 보게 하는 힘을 가진 작가 강경수가 이번 작품에서 주목한 곳은 기후 위기 시대를 통과하고 있는 오늘날의 북극이다. 한때 새하얀 겨울 왕국의 제일가는 사냥꾼이었지만 빙하가 녹아내리는 북극에서 굶주림에 시달리게 된 북극곰 ‘눈보라’의 모험을 담았다. 전례 없는 기상 이변으로 드러나는 우리 사회의 어두운 면면을 비추어 보이는 선 굵은 작품이다. 환경 문제와 더불어 진실보다 거짓에 환호하는 세상에 대한 풍자, 그 속에서 나다움을 지키기 위해 애쓰는 모두를 위한 철학적 질문을 품은 이 책은 가정이나 학교에서 여럿이 함께 읽고 의견을 나누기에도 맞춤하다."), String.format("“저를 환대해주셔서 고마워요.”\r\n" + 
														"좋은 삶이 무엇인지 알고 좋은 삶을 꿈꾸는 소년들을 위해\r\n" + 
														"\r\n" + 
														"누가 책을 읽어준 기억이 한 번도 없는 소년, 먹고사는 일의 급급함을 너무나 잘 아는 소년, 파란색은 9호 연두색은 10호로 구분하는 소년…. ‘이런 곳’에서 살았다는 흔적을 남기고 싶어 하지 않는 소년들과 마음과 정성을 다하고도 소년들의 삶에서 삭제되어야 하는 국어선생님. 이들이 소년원이라는 공간에서 함께 책을 읽으며 ‘환대’를 배우고 서로의 마음을 조금씩 물들인 일 년의 성장 기록을『소년을 읽다』에 담았다. 저자 서현숙은 책읽기를 통해 소년들의 구체적 삶의 서사를 접하면서 자신의 고정관념과 편견이 깨지는 경험을 한다. 영혼까지 병든 것은 아닌 소년들을 보며, 죗값을 치르고 다시 우리 사회의 구성원으로 돌아올 소년들에게 우리 사회가, 어른들이 어떤 역할을 해야 할지 고민하게 한다."), String.format("2017년 볼로냐 라가치상 특별상 수상 작가 요시타케 신스케 신작!\r\n" + 
																"\r\n" + 
																"힘들 땐 어떻게 해야 할까?\r\n" + 
																"내 마음을 아무도 알아 주지 않으면 어떻게 해야 할까?\r\n" + 
																"아이와 어른의 다양한 질문에 대한 답을 들려주는 그림책."), String.format("“정말 궁금한 게 있어요.\r\n" + 
																		"그날로 다시 돌아간다면 무언가 달라졌을까요.”\r\n" + 
																		"\r\n" + 
																		"『우아한 거짓말』부터 『아몬드』 『페인트』 『유원』까지, 독자들의 큰 사랑을 받은 작품들의 뒷이야기를 엮은 소설집 『두 번째 엔딩』이 출간되었다. 김려령 배미주 이현 김중미 손원평 구병모 이희영 백온유 등 베스트셀러 작가들의 완성도 높은 단편이 실렸다. 전작에서 주인공이 아니었던 인물들의 속내까지 따스하게 보듬으며 모든 삶이 조명받아 마땅한 가치가 있다는 메시지를 전한다.\r\n" + 
																		"\r\n" + 
																		"동생을 잃은 언니의 아픈 마음을 담은 「언니의 무게」(김려령), 처음 직업의 세계에 발을 들이는 이들이라면 누구나 공감할 만한 SF 「초보 조사관 분투기」(배미주), 탈북을 결심한 가족 때문에 자신의 꿈을 포기해야 하는 주인공의 이야기 「보통의 꿈」(이현), 농촌에서 젊은 농부로서의 삶을 그려 나가는 「나는 농부 김광수다」(김중미), 끔찍한 사고를 목격한 남자의 세상을 다룬 「상자 속의 남자」(손원평), 아픈 상처를 지닌 두 사람이 새로운 공동체를 꾸려 가는 이야기 「초원조의 아이에게」(구병모), 사회의 차별적 시선을 견디며 자신만의 삶을 개척하는 인물을 바라보는 「모니터」(이희영), 축구 선수를 그만둔 뒤 ‘낙오자’라는 세상의 시선을 담담히 마주하는 「서브」(백온유)까지. 소설을 이미 읽은 이들에겐 반가운 인물들을 다시 만나는 기쁨을, 처음 읽는 이들에게는 풍성한 이야기를 선사하는 선물 같은 책이다."), String.format("노벨문학상 수상 작가 토니 모리슨 국내 첫 산문집\r\n" + 
																				"흑인, 여성, 소설가로서 세상에 기울인 지적인 온정\r\n" + 
																				"\r\n" + 
																				"“저는 남과 다른 목소리가 지워질까, 쓰이지 않은 소설이 지워질까 두렵습니다. 그릇된 사람들의 귀에 들어갈까 봐 속삭이거나 삼켜야 하는 시들, 지하에서 번성하는 금지된 언어, 권력에 도전하는 수필가들의 묻지 못한 물음, 무대에 올리지 못한 연극, 제작이 취소된 영화 등이 지워지는 데 대한 불안을 감출 수 없습니다. 이것은 악몽입니다. 마치 온 우주가 보이지 않는 잉크로 그려지고 있는 것 같습니다.” ─ 「위험」, 15-16쪽\r\n" + 
																				"\r\n" + 
																				"미국 흑인 문학의 상징적 인물이자 흑인 여성 최초로 노벨문학상을 수상한 작가 토니 모리슨. 그는 두 아이를 홀로 키우며 출판편집자로 영문학 강사로 일하는 와중에 마흔에 소설가로 데뷔했고, 그 후 열한 편의 소설을 썼다. 그리고 2019년 88세를 일기로 타계했다. 미국 흑인 문학을 대표하는 작가인 만큼 그는 소설 집필 외에도 인종차별과 젠더 갈등, 신자유주의와 세계화의 위험, 문학과 교육이 처한 불행에 대해 끊임없이 생각하고 날카로운 견해를 펼쳤던 것으로 유명하다.") };
		
		
		try {
			
			Connection conn = DBUtil.open();
			PreparedStatement pstat;
			PreparedStatement pstat2;
			Statement stat;
			ResultSet rs = null;
			Random rnd = new Random();
			
			String sql = "";
			String sql2 = "";
			String sql3 = "";
			String seqBook = "";
			
			
			while (isbn.size() < 2400) {
				isbn.add((3330000000000L + rnd.nextInt(1000000000) + 1000000000) + "");
			}
			
			Iterator<String> iter = isbn.iterator();
			
			sql = "insert into tblBook(seq, seqAuthor, seqSCategory, title, publisher, price, salePrice, pubDate, summary, isbn, copy, image, page, contents) values(seqBook.nextVal, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstat = conn.prepareStatement(sql);
			
			sql2 = "select max(seq) as seq from tblBook";
			stat = conn.createStatement();
			
			sql3 = "insert into tblInventory (seq, seqBook, amount) values (seqInventory.nextVal, ?, ?)";
			pstat2 = conn.prepareStatement(sql3);
			
			for (int i=1; i<=120; i++) {
				if (i == 2) {
					//국내 - 소설 - 외국소설 제외 (해리포터)
					continue;
				}
				for (int j=0; j<20; j++) {

					int temp = price[rnd.nextInt(price.length)];
					pstat.setString(1, (rnd.nextInt(15) + 1) + "");
					pstat.setString(2, i + "");
					pstat.setString(3, title[rnd.nextInt(title.length)]);
					pstat.setString(4, publisher[rnd.nextInt(publisher.length)]);
					pstat.setInt(5, temp);
					pstat.setInt(6, Math.floorDiv(temp, 10) * 9);					
					pstat.setString(7, pubDate[rnd.nextInt(pubDate.length)]);
					pstat.setString(8, summary[rnd.nextInt(summary.length)]);
					if (iter.hasNext()) {
						pstat.setString(9, iter.next());
					}
					pstat.setString(10, copy[rnd.nextInt(copy.length)]);
					pstat.setString(11, image[rnd.nextInt(image.length)]);
					pstat.setString(12, (rnd.nextInt(300) + 200) + "");
					pstat.setString(13, contents[rnd.nextInt(contents.length)]);
					
					System.out.println("소분류번호 : " + i + " | 결과 : " + pstat.executeUpdate());
					
					//도서재고 테이블 추가
					rs = stat.executeQuery(sql2);
					
					if (rs.next()) {
						seqBook = rs.getString("seq");
					}
					
					pstat2.setString(1, seqBook);
					pstat2.setInt(2, rnd.nextInt(10) + 1);
					
					System.out.println("도서번호 : " + seqBook + " | 결과 : " + pstat2.executeUpdate());
					
				}
			}

			stat.close();
			pstat.close();
			pstat2.close();
			rs.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		
	}
	
}
