package org.strangeway.tsr.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static org.strangeway.tsr.psi.TslTokenTypes.*;
%%

%{
  public _TslLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _TslLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

IDENTIFIER=([:letter:]|[_])([:letter:]|[._\-0-9\$])*

ESCAPE_SEQUENCE=\\[^\r\n]
DOUBLE_QUOTED_STRING=\"([^\\\"\r\n]|{ESCAPE_SEQUENCE})*(\"|\\)?
SINGLE_QUOTED_STRING=\'([^\\\'\r\n]|{ESCAPE_SEQUENCE})*(\'|\\)?

INTEGER_LITERAL=0|[1-9][0-9]*

DIGIT=[0-9]
DOUBLE_LITERAL=(({FLOATING_POINT_LITERAL1})|({FLOATING_POINT_LITERAL2})|({FLOATING_POINT_LITERAL3}))
FLOATING_POINT_LITERAL1=({DIGIT})+"."({DIGIT})*({EXPONENT_PART})?
FLOATING_POINT_LITERAL2="."({DIGIT})+({EXPONENT_PART})?
FLOATING_POINT_LITERAL3=({DIGIT})+({EXPONENT_PART})
EXPONENT_PART=[Ee]["+""-"]?({DIGIT})*

WHITE_SPACE=\s+

%%

<YYINITIAL> {
    ","                                  { return COMMA; }
    ":"                                  { return COLON; }
    "true"                               { return TRUE; }
    "false"                              { return FALSE; }
    "null"                               { return NULL; }
    "["                                  { return LBRACKET; }
    "]"                                  { return RBRACKET; }
    "("                                  { return LPARENTH; }
    ")"                                  { return RPARENTH; }
    "{"                                  { return LBRACE; }
    "}"                                  { return RBRACE; }
    "@"                                  { return STRUDEL; }
    "="                                  { return ASSIGN; }

    {IDENTIFIER}                         { return IDENTIFIER; }
    {INTEGER_LITERAL}                    { return INTEGER_NUMBER; }
    {DOUBLE_LITERAL}                     { return DOUBLE_NUMBER; }
    {DOUBLE_QUOTED_STRING}               { return DOUBLE_QUOTED_STRING; }
    {SINGLE_QUOTED_STRING}               { return SINGLE_QUOTED_STRING; }
    {WHITE_SPACE}                        { return WHITE_SPACE; }
}

[^] { return BAD_CHARACTER; }