package com.example.historian_api.utils.constants;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StaticText {
    private String aboutText;
    private String privacyText;
    private String technicalSupportContactInfo;
}
