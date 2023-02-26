package com.uc.credit.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Message {
    String title;
    String body;
}
