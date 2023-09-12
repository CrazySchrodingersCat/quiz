//package quad.quiz.controllers.service;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import org.springframework.stereotype.Service;
//import quad.quiz.domain.Question;
//import quad.quiz.domain.dto.QuestionResponse;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//@Slf4j
//@Service
//public class QuestionServiceImpl implements IQuestionService {
//    private List<Question> questions;
//    private final String opentdbURL = "https://opentdb.com/api.php?amount=5";
//    @Override
//    public List<QuestionResponse> getQuestions() {
//
//        if (questions == null) {
//            fetchQuestionsFromAPI(); // Fetch questions if not already fetched
//        }
//
//        // Check if questions are still null
//        if (questions == null) {
//            return Collections.emptyList(); // Return an empty list if questions are still null
//        }
//
//        return questions.stream().map(this::mapToQuestionResponse).toList();
//
//
////        return questions.stream().map(this::mapToQuestionResponse).toList();
//    }
//
//    private QuestionResponse mapToQuestionResponse(Question question) {
////        return QuestionResponse.builder().questionText(question.getQuestionText()).options(question.getOptions()).build();
//        return null;
//    }
//
//    @Override
//    public List<Boolean> checkAnswers(Long questionId, List<String> answers) {
//        return null;
//    }
//
//    public List<Question> fetchQuestionsFromAPI() {
//        try {
//            HttpClient httpClient = HttpClients.createDefault();
//            HttpGet httpGet = new HttpGet(opentdbURL);
//            HttpResponse response = httpClient.execute(httpGet);
//
//            // Check the response status code
//            int statusCode = response.getStatusLine().getStatusCode();
//            if (statusCode == 200) {
//                // Parse the JSON response
//                String jsonResponse = EntityUtils.toString(response.getEntity());
//                Gson gson = new Gson();
//                JsonObject json = JsonParser.parseString(jsonResponse).getAsJsonObject();
//                JsonArray resultsArray = json.getAsJsonArray("results");
//
////                List<Question> questions = new ArrayList<>();
//
//                for (int i = 0; i < resultsArray.size(); i++) {
//                    JsonObject result = resultsArray.get(i).getAsJsonObject();
//                    String questionText = result.get("question").getAsString();
//                    String type = result.get("type").getAsString();
//                    String correctAnswer = result.get("correct_answer").getAsString();
//
//
//                    JsonArray incorrectAnswersArray = result.getAsJsonArray("incorrect_answers");
//                    List<String> incorrectAnswers = new ArrayList<>();
//
//                    for (int j = 0; j < incorrectAnswersArray.size(); j++) {
//                        incorrectAnswers.add(incorrectAnswersArray.get(j).getAsString());
//                    }
//
//                    List<String> options = new ArrayList<>(incorrectAnswers);
//                    options.add(correctAnswer);
//
//                    //var question = new Question(questionText,type, options, correctAnswer);
//
//
//                    //questions.add(question);
//
//
//                }
//
//                return questions;
//            } else {
//                // Handle the error (e.g., log or throw an exception)
//                return null;
//            }
//        } catch (Exception e) {
//            log.info("Smth went wrong");
//            return null;
//        }
//    }
//}
