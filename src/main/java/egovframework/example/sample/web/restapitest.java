package egovframework.example.sample.web;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.embedding.EmbeddingRequest;
import com.theokanning.openai.service.OpenAiService;

import egovframework.example.API.*;

@RestController
@RequestMapping("/restapi")
public class restapitest {
	
	@ResponseBody
	@GetMapping("/{name}")
	public String sayHello(@PathVariable String name){	
		String result = "Hello eGovFramework! name: " + name;
		return result;
	}

	
	//embedding model: text-embedding-ada-002
	@PostMapping("/postMethod")
	public ResponseEntity<?> sendQuestion(@RequestBody Map<String, String> list){
		OpenAiService service = new OpenAiService(Keys.OPENAPI_KEY ,Duration.ofMinutes(9999));
		System.out.println(list.get("Q"));
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(list.get("Q"))
                .model("gpt-3.5-turbo")
                .echo(true) 
                .maxTokens(8191)
                .temperature((double) 1.0f)
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
        
        return ResponseEntity.ok(service.createCompletion(completionRequest).getChoices());
        //did some work on project
	}
	
	@PostMapping("/postEmbedd")
	public ResponseEntity<?> sendEmbedding(@RequestBody Map<String,String> list) {
		OpenAiService service = new OpenAiService(Keys.OPENAPI_KEY,Duration.ofMinutes(9999));
		List<String> inpStr = new ArrayList<String>();
		inpStr.add(list.get("Q"));

		new EmbeddingRequest();
		EmbeddingRequest emb = EmbeddingRequest.builder()
				.input(inpStr)
				.model("text-embedding-ada-002")
				.build();
		
		service.createEmbeddings(emb).getData().forEach(System.out::println);
		
		return ResponseEntity.ok(service.createEmbeddings(emb).getData());
	}
	
	@PostMapping("/postEmbedd2")
	public ResponseEntity<?> fromSingleton2(@RequestBody Map<String,String> list){
		List<String> input = new ArrayList<String>();
		input.add(list.get("Q"));
		return ResponseEntity.ok(OAISingleton.getInstance()
				.getEmbeddingData(input));
	}
	
}
