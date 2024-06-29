package com.arian.example.demo.domain.dto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Members {

   int a;

   int b;

}
