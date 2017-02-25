package hylaa.config.web.tool.rpc;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TerminalController {

	@PostMapping(value = "/TerminalService", consumes = "application/json")
	public JsonRpcResponse login(@RequestBody JsonRpcRequest request) {
		return new JsonRpcResponse().setId(request.getId()).setJsonrpc(request.getJsonrpc()).setResult(request.getMethod());
	}

	@Setter
	@Getter
	public static final class JsonRpcRequest {
		int id;
		String jsonrpc;
		String method;
		String params[];
	}

	@Setter
	@Getter
	@Accessors(chain = true)
	public static final class JsonRpcResponse {
		int id;
		String jsonrpc;
		String result;
		JsonRpcError error;
	}

	@Setter
	@Getter
	public static final class JsonRpcError {
		int code;
		String message;
		String name;
	}
}