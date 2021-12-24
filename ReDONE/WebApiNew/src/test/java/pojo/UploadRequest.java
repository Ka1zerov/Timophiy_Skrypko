package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UploadRequest{
	private String path;

	@Builder.Default
	private String mode = "add";

	@Builder.Default
	private boolean autorename = false;

	@Builder.Default
	private boolean mute = false;

	@Builder.Default
	@JsonProperty("strict_conflict")
	private boolean strictConflict = false;


}