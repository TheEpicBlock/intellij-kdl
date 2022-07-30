package nl.theepicblock.intellijkdl;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import nl.theepicblock.intellijkdl.psi.KdlTypes;

%%

%class KdlLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

BOM=\uFEFF

LINESPACE={NEWLINE} | {WS}
WS={BOM} | {UNICODE_SPACE}

BARE_IDENTIFIER=([^\\\/(){}<>;\[\]=,\"0-9+\-\u000D\u000A\u0085\u000C\u2028\u2029\uFEFF\u0009\u0020\u00A0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200A\u202F\u205F\u3000] {IDENTIFIER_CHAR}*) | (({SIGN}) ([^\\\/(){}<>;\[\]=,\"0-9\u000D\u000A\u0085\u000C\u2028\u2029\uFEFF\u0009\u0020\u00A0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200A\u202F\u205F\u3000] {IDENTIFIER_CHAR}*)?)
IDENTIFIER_CHAR=[^\\\/(){}<>;\[\]=,\"\u000D\u000A\u0085\u000C\u2028\u2029\uFEFF\u0009\u0020\u00A0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200A\u202F\u205F\u3000]
NEWLINE=\r\n | [\u000D\u000A\u0085\u000C\u2028\u2029]

UNICODE_SPACE=[\u0009\u0020\u00A0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200A\u202F\u205F\u3000]

CHARACTER="\\" {ESCAPE} | [^\"]
ESCAPE=[\"\\/bfnrt] | "u{" {HEXDIGIT}{1, 6} "}"
HEXDIGIT=[0-9a-fA-F]

ESCAPED_STRING=\"{CHARACTER}*\"
RAW_STRING=r#\"[^]\"
STRING={ESCAPED_STRING} | {RAW_STRING}

DECIMAL={SIGN}? {INTEGER} ('.' {INTEGER})? {EXPONENT}?
EXPONENT=('e' | 'E') {SIGN}? {INTEGER}
INTEGER={DIGIT} ({DIGIT} | '_')*
DIGIT=[0-9]
SIGN=[+\-]

HEX={SIGN}? "0x" {HEXDIGIT} ({HEXDIGIT} | '_')*
OCTAL={SIGN}? "0o" [0-7] [0-7_]*
BINARY={SIGN}? "0b" [01] [01_]*
BOOLEAN="true" | "false"


%%

{NEWLINE}                                       { return KdlTypes.NEWLINE; }
{UNICODE_SPACE}                                 { return KdlTypes.UNICODESPACE; }
{BOM}                                           { return KdlTypes.BOM; }
{BOOLEAN}                                       { return KdlTypes.BOOLEAN; }
"null"                                          { return KdlTypes.NULL; }
{BARE_IDENTIFIER}                               { return KdlTypes.BAREIDENTIFIER; }
{STRING}                                        { return KdlTypes.STRING; }
{DECIMAL}                                       { return KdlTypes.DECIMAL; }
{HEX}                                           { return KdlTypes.HEX; }
{OCTAL}                                         { return KdlTypes.OCTAL; }
{BINARY}                                        { return KdlTypes.BINARY; }
"/-"                                            { return KdlTypes.CTXCOMMENT; }
"\\"                                            { return KdlTypes.BACKSLASH; }
"="                                             { return KdlTypes.EQUALS; }
"{"                                             { return KdlTypes.STARTNODE; }
"}"                                             { return KdlTypes.ENDNODE; }
"("                                             { return KdlTypes.STARTTYPE; }
")"                                             { return KdlTypes.ENDTYPE; }
";"                                             { return KdlTypes.SEMICOLON; }

[^]                                             { return TokenType.BAD_CHARACTER; }