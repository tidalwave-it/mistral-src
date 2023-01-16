grammar TIFF;

@header
  {
    import java.util.Optional;
    import it.tidalwave.image.codegenerator.TIFFRecord;
    import it.tidalwave.image.codegenerator.TIFFEnumValueName;
  }

prog returns [List<TIFFRecord> result]
	:	{ $result = new ArrayList<TIFFRecord>(); }
	    (stat { if ($stat.result != null) $result.add($stat.result); } )+ ;

stat returns [TIFFRecord result]
	:	tiffRecord=expr NEWLINE { $result = $expr.result; }
	|	NEWLINE
	;

expr returns [TIFFRecord result]
	:   id=INT name type=TYPE enums=enumSet?
            {
                $result = new TIFFRecord($id.text, $name.text, $type.text,
                    ((ExprContext)_localctx).enums != null ? $enums.result : new ArrayList<TIFFEnumValueName>()); // FIXME
            };

enumSet	returns [List<TIFFEnumValueName> result]
	:	{ $result = new ArrayList<TIFFEnumValueName>(); }
	     ENUM enumv1=enumV { $result.add($enumv1.result); } (COMMA enumvX=enumV { $result.add($enumvX.result); } )*;

enumV returns [TIFFEnumValueName result]
	:	id=(INT | HEX) EQUALS name { $result = new TIFFEnumValueName($id.text, $name.text); };

COMMA	:	',';

ENUM	:	'enum:';

EQUALS	:	'=';

HEX	:	'0x' ('0'..'9' | 'a'..'f' | 'A'..'F') ('0'..'9' | 'a'..'f' | 'A'..'F') ('0'..'9' | 'a'..'f' | 'A'..'F') ('0'..'9' | 'a'..'f' | 'A'..'F');

WS	:	(' ' | '\t' | '\r' | ':')+ -> channel(HIDDEN);

COMMENT	:	'#' (~'\n')* -> channel(HIDDEN);

INT	:	('-' | '+')? ('0'..'9')+;

NEWLINE	:	'\n';

TYPE	:	'ASCII'
	|	'ASCII[]'
	|	'RATIONAL'
	|	'SRATIONAL'
	|	'RATIONAL[]'
	|	'SRATIONAL[]'
	|	'BYTE'
	|	'FLOAT'
	|	'LONG'
	|	'SHORT'
	|	'SSHORT'
	|	'BYTE[]'
	|	'FLOAT[]'
	|	'LONG[]'
	|	'SHORT[]'
	|	'SSHORT[]'
	|	'UNDEFINED'
	|	'UNDEFINED[]'
	|	'DOUBLE'
	|	'DOUBLE[]'
        |       'DATE'
        |       'TIME'
        |       'DATETIME'
	;

CHARS	:	('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | '0'..'9' | '/' | '-' | '_' | '(' | ')')*;

name	:	CHARS (INT | CHARS)*;
