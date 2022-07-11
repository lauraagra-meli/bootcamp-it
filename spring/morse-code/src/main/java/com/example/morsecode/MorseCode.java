package com.example.morsecode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MorseCode {
    private String code;

    public String convertedCode(String code) {
        return "x";

        switch (code) {
            case "   ":
                codeTwo.append(" ");
                break;
            case ".-":
                codeTwo.append("A");
                break;
            case "-...":
                codeTwo.append("B");
                break;
            case "-.-.":
                codeTwo.append("C");
                break;
            case "-..":
                codeTwo.append("D");
                break;
            case ".":
                codeTwo.append("E");
                break;
            case "..-.":
                codeTwo.append("F");
                break;
            case "--.":
                codeTwo.append("G");
                break;
            case "....":
                codeTwo.append("H");
                break;
            case "..":
                codeTwo.append("I");
                break;
            case ".---":
                codeTwo.append("J");
                break;
            case "-.-":
                codeTwo.append("K");
                break;
            case ".-..":
                codeTwo.append("L");
                break;
            case "--":
                codeTwo.append("M");
                break;
            case "-.":
                codeTwo.append("N");
                break;
            case "---":
                codeTwo.append("O");
                break;
            case ".--.":
                codeTwo.append("P");
                break;
            case "--.-":
                codeTwo.append("Q");
                break;
            case ".-.":
                codeTwo.append("R");
                break;
            case "...":
                codeTwo.append("S");
                break;
            case "-":
                codeTwo.append("T");
                break;
            case "..-":
                codeTwo.append("U");
                break;
            case "...-":
                codeTwo.append("V");
                break;
            case ".--":
                codeTwo.append("W");
                break;
            case "-..-":
                codeTwo.append("X");
                break;
            case "-.--":
                codeTwo.append("Y");
                break;
            case "--..":
                codeTwo.append("Z");
                break;
        }
    }

}
