package POJOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetMetadataRequest{
    private String path;

    @JsonProperty("include_has_explicit_shared_members")
    private boolean includeHasExplicitSharedMembers;

    @JsonProperty("include_media_info")
    private boolean includeMediaInfo;

    @JsonProperty("include_deleted")
    private boolean includeDeleted;
}