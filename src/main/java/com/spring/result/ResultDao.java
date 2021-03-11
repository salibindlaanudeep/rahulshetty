package com.spring.result;

import java.util.List;

public interface ResultDao {

    public void addResult(Result result);

    public void editResult(Result result);

    public List<Result> listResults();

    public Result getResultById(int resultId);

    public List<Result> listResultByStudent(int studentId);

    public void deleteResult(Result result);

}
