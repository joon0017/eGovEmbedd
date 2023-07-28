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

@RestController
@RequestMapping("/restapi")
public class restapitest {
	
	@ResponseBody
	@GetMapping("/{name}")
	public String sayHello(@PathVariable String name){	
		String result = "Hello eGovFramework! name: " + name;
		return result;
	}

	
	//free: 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
	//paid: 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
	//embedding model: text-embedding-ada-002
	@PostMapping("/postMethod")
	public ResponseEntity<?> sendQuestion(@RequestBody Map<String, String> list){
		//유로계정
		OpenAiService service = new OpenAiService("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",Duration.ofMinutes(9999));
		
		//무료계정
//		OpenAiService service = new OpenAiService("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",Duration.ofMinutes(9999));
		System.out.println(list.get("Q"));
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(list.get("Q"))
                .model("text-embedding-ada-002") 
//                .model("gpt-3.5-turbo")
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
		OpenAiService service = new OpenAiService("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",Duration.ofMinutes(9999));
//		List<String> inpStr = <"Sample document text goes here", "there will be several phrases in each batch">;
		List<String> inpStr = new ArrayList<String>();
		inpStr.add(list.get("Q"));
		inpStr.add(list.get("R"));
		inpStr.add(list.get("S"));

		new EmbeddingRequest();
		EmbeddingRequest emb = EmbeddingRequest.builder()
				.input(inpStr)
				.model("text-embedding-ada-002")
				.build();
		
		service.createEmbeddings(emb).getData().forEach(System.out::println);
		
		return ResponseEntity.ok(service.createEmbeddings(emb).getData());
	}
}
