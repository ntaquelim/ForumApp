package com.solera.forumbe.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReturnBanned {
    private String bannedWord;
    private Boolean buttonShown;
}
