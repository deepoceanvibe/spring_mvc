package com.spring.mvc.chap04;

import com.spring.mvc.chap04.entity.Score;
import com.spring.mvc.chap04.repository.ScoreRepository;
import com.spring.mvc.chap04.repository.ScoreRepositoryImp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreRepositoryTest {
    ScoreRepository repository = new ScoreRepositoryImp();


    @Test
    public void ScoreRepositoryStaticvarTest() {
        // 접근 제한자가 public 으로 풀려있는 동안만 실행 가능
        // System.out.println(ScoreRepositoryImp.scoreMap);
        // System.out.println(ScoreRepositoryImp.sequence);
    }


    // TDD 방법
    // -> 기능 하나하나 별로 test 코드도 하나하나 분리해서 만듬
    // 1. 원본 클래스에 원하는 기능을 구현하지는 말고 선언만 해 둔다.
    // 2. 테스트 코드 내부에 원하는 기능대로 작성되었을 때 어떤 결과가 나올지 단언해둔다.
    // 3. 테스트가 통과될때까지, 원본 클래스를 수정하면서 계속 테스트 해본다.

    // 테스트 대상인 ScoreRepositoryImp 처음에 선언해준다.

    @Test
    public void findAllTest() {
        // GWT 패턴 (AAA패턴)

        // GIVEN : 테스트를 위해 사전에 설정해야 하는 '데이터를 선언'
        // findAll은 특별한 조건 없이 전체 데이터를 가져오므로 GIVEN 없음 (SELECT * FROM 과 비슷)

        // WHEN : 테스트 대상 '메서드를 실행'하는 구간, 보통 한 줄로 작성함
        List<Score> result = repository.findAll();

        // THEN : '테스트 결과'가 이렇게 나올것이다 ~라는 단언
        // 나는 result 내부에 3개의 Score가 있다고 단언한다.
        // scoreMap에 3개의 데이터를 넣었으므로, 3개가 나와야 정상
        System.out.println(result.size() == 3);
        assertEquals(3, result.size());

    }


    @Test
    @DisplayName("저장소에서 2번 유저를 가져와서 이름과 국어성적 비교")
    public void findByStudentNumberTest() {
        // given (2번 학생 정보가 실제 정보와 일치하는지 체크)
        int studentNumber = 2;

        // when (2번 학생 정보를 넣어 findByStudentNumber를 호출하고, 결과는 result에 저장)
        Score result = repository.findByStudentNumber(studentNumber);

        // then
        // (2번 유저의 점수를 얻어왔으므로, getter로 조사시 33점일 것이다.)
        assertEquals(33, result.getKorScore());
        // (2번 유저의 이름을 얻어왔으므로, getter로 조사시 "이부트"일 것이다.)
        assertEquals("이부트", result.getName());
    }

    @Test
    @DisplayName("없는 번호로 조회시 null이어야 함")
    public void notFindByStudentNumberTest() {
        // given
        int studentNumber = 99;
        // when
        Score result = repository.findByStudentNumber(studentNumber);
        // then
        assertNull(result); // 해당 변수가 null 이면 통과, 아니면 실패하는 검사
    }

    @Test
    @DisplayName("새로운 성적정보를 저장하면 전체 데이터의 개수는 4개가 된다.")
    public void saveTest() {
        // given
        Score score = new Score();
        score.setName("티디디");
        score.setKorScore(100);
        score.setEngScore(70);
        score.setMathScore(80);

        // when (저장한 후 전체 데이터 가져오기)
        boolean boolResult = repository.save(score);
        List<Score> result = repository.findAll();

        // then (저장하면 총 데이터가 4개가 된다.)
        assertEquals(4, result.size());
        assertTrue(boolResult);
    }

    @Test
    @DisplayName("저장소에서 2번 학생 삭제 했을 때 리스트 전체 조회시 개수는 2개, 2번 학생 조회는 null")
    public void deleteTest() {
        // given (학생 번호 저장)
        int studentNumber = 2;

        // when (해당 번호 학생 삭제, findAll()로 전체 데이터를 가져오고 2번 학생만 가져오기)
        boolean result = repository.deleteByStudentNumber(studentNumber);
        List<Score> scoreList = repository.findAll();       // 2개만 가져와짐
        Score score = repository.findByStudentNumber(studentNumber);     // null

        // then (전체 목록 길이는 2일 것이고, score 변수에는 null이 담길 것이다.)
        assertEquals(2, scoreList.size());  // assertThat(2).isEqualTo(ScoreList.size()); 로도 쓸 수 있다.
        assertNull(score);
        assertTrue(result);
    }






}
