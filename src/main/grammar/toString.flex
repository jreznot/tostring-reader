/*
 * Copyright © 2022 Yuriy Artamonov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the “Software”), to deal in the Software without
 * restriction, including without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies
 * or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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

STRUDEL_HEX=[@][a-f0-9]+

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
    "="                                  { return ASSIGN; }

    {STRUDEL_HEX}                        { return STRUDEL_HEX; }
    {IDENTIFIER}                         { return IDENTIFIER; }
    {INTEGER_LITERAL}                    { return INTEGER_NUMBER; }
    {DOUBLE_LITERAL}                     { return DOUBLE_NUMBER; }
    {DOUBLE_QUOTED_STRING}               { return DOUBLE_QUOTED_STRING; }
    {SINGLE_QUOTED_STRING}               { return SINGLE_QUOTED_STRING; }
    {WHITE_SPACE}                        { return WHITE_SPACE; }
}

[^] { return BAD_CHARACTER; }