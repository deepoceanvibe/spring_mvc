package com.spring.mvc.chap04.repository;


import com.spring.mvc.chap04.entity.Score;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository     // 빈 컨테이너 내부에 ScoreRepositoryImp 객체가 생성됨
public class ScoreRepositoryImp implements ScoreRepository {

    // key : 학번, value : 성적정보
    private static final Map<Integer, Score> scoreMap;
    // 학번(primary key)에 사용할 일련 번호
    private static int sequence;

    // 정적 변수를 초기화해줄 정적 블록
    static {
        scoreMap = new HashMap<>();
        Score stu1 = new Score("김자바", 100, 50, 70, ++sequence, 0, 0);
        Score stu2 = new Score("이부트", 33, 56, 0, ++sequence, 0, 0);
        Score stu3 = new Score("박디비", 88, 12, 54, ++sequence, 0, 0);

        scoreMap.put(stu1.getStudentNumber(), stu1);
        scoreMap.put(stu2.getStudentNumber(), stu2);
        scoreMap.put(stu3.getStudentNumber(), stu3);
        System.out.println(scoreMap);
    }

    @Override
    public List<Score> findAll() {
        // 빈 ArrayList 생성
        List<Score> resultList = new ArrayList<Score>();

        // 반복문 이용해서 resultList에 Score 객체(ScoreMap.values()) 채워넣기 (3바퀴)
        for(Score score : scoreMap.values()) {
            resultList.add(score);
        }

        // System.out.println(resultList);
        return resultList;
    }

    @Override
    public boolean save(Score score) {
        if(scoreMap.containsKey(score.getStudentNumber())) {
            return false;
        }
        score.setStudentNumber(++sequence);     // 사용된 적 없는 학번 정보를 setter로 추가
        scoreMap.put(score.getStudentNumber(), score);
        return true;
    }

    @Override
    public boolean deleteByStudentNumber(int studentNumber) {
        if(!scoreMap.containsKey(studentNumber)) {
            return false;
        }
        scoreMap.remove(studentNumber);
        return true;

    }

    @Override
    public Score findByStudentNumber(int studentNumber) {
        return scoreMap.get(studentNumber);
    }
}
