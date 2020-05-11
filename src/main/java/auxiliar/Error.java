package auxiliar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Error {

	private String message;
	public int status;

	public Error(Exception e, int status) {
		this.message = e.getMessage();
		this.status = status;
	}

	public Error(Exception e) {
		this.message = e.getMessage();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
