/* JavaToDartTranspiler.java */
/* Generated By:JavaCC: Do not edit this line. JavaToDartTranspiler.java */
package java_to_dart_transpiler;

import java.io.*;
import java.util.*;


public class JavaToDartTranspiler implements JavaToDartTranspilerConstants {
  public static void main(String[] args) throws Exception {
    String caminhoDoArquivo = "input.txt";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                JavaToDartTranspiler.class.getResourceAsStream("/java_to_dart_transpiler/input.txt")))) {
            String linha;
            String inputString="";
            while ((linha = br.readLine()) != null) {
                inputString+=linha;
            }
                        StringReader stringReader = new StringReader(inputString);
                        JavaToDartTranspiler parser = new JavaToDartTranspiler(stringReader);
                        String result=parser.codeBlock();

            System.out.println("\n"+result);
            BufferedWriter writer =  new BufferedWriter(new FileWriter("src/java_to_dart_transpiler/output.txt"));
            writer.write(result);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
  }

  static HashMap<String, String> symbolTable = new HashMap<>();

  public static void addVariable(String type, String identifier) throws ParseException {
    if (symbolTable.containsKey(identifier)) {
      throw new ParseException("Variavel " + identifier + " ja foi declarada.");
    }
    symbolTable.put(identifier, type);
  }

  public static String checkVariableAndReturnType(String identifier) throws ParseException {
    if (!symbolTable.containsKey(identifier)) {
      throw new ParseException("Variavel " + identifier + " nao foi declarada.");
    }
    return symbolTable.get(identifier);
  }

  static final public String type() throws ParseException {
    trace_call("type");
    try {
String code = "";
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case INTSYMBOL:{
        jj_consume_token(INTSYMBOL);
code = "int";
        break;
        }
      case STRINGSYMBOL:{
        jj_consume_token(STRINGSYMBOL);
code = "String";
        break;
        }
      case BOOLEAN:{
        jj_consume_token(BOOLEAN);
code = "bool";
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
{if ("" != null) return code;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("type");
    }
}

  static final public String compareBooleanOperator() throws ParseException {
    trace_call("compareBooleanOperator");
    try {
String code="";
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case EQUALS:{
        jj_consume_token(EQUALS);
code+=token.image;
        break;
        }
      case NOT_EQUALS:{
        jj_consume_token(NOT_EQUALS);
code+=token.image;
        break;
        }
      case LESS_THAN:{
        jj_consume_token(LESS_THAN);
code+=token.image;
        break;
        }
      case LESS_THAN_EQUALS:{
        jj_consume_token(LESS_THAN_EQUALS);
code+=token.image;
        break;
        }
      case GREATER_THAN:{
        jj_consume_token(GREATER_THAN);
code+=token.image;
        break;
        }
      case GREATER_THAN_EQUALS:{
        jj_consume_token(GREATER_THAN_EQUALS);
code+=token.image;
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
{if ("" != null) return code;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("compareBooleanOperator");
    }
}

  static final public String algebricOperator() throws ParseException {
    trace_call("algebricOperator");
    try {
String code="";
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PLUS:{
        jj_consume_token(PLUS);
code+=token.image;
        break;
        }
      case MINUS:{
        jj_consume_token(MINUS);
code+=token.image;
        break;
        }
      case MULTIPLY:{
        jj_consume_token(MULTIPLY);
code+=token.image;
        break;
        }
      case DIVIDE:{
        jj_consume_token(DIVIDE);
code+=token.image;
        break;
        }
      case MODULO:{
        jj_consume_token(MODULO);
code+=token.image;
        break;
        }
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
{if ("" != null) return code;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("algebricOperator");
    }
}

  static final public String booleanOperator() throws ParseException {
    trace_call("booleanOperator");
    try {
String code="";
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case AND:{
        jj_consume_token(AND);
code+=token.image;
        break;
        }
      case OR:{
        jj_consume_token(OR);
code+=token.image;
        break;
        }
      default:
        jj_la1[3] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
{if ("" != null) return code;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("booleanOperator");
    }
}

  static final public String compareBoolean() throws ParseException {
    trace_call("compareBoolean");
    try {
String code="";
      jj_consume_token(INTEGER_LITERAL);
code += token.image;
      compareBooleanOperator();
code+= " " + token.image + " ";
      jj_consume_token(INTEGER_LITERAL);
code += token.image;
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case EQUALS:
        case NOT_EQUALS:
        case LESS_THAN:
        case LESS_THAN_EQUALS:
        case GREATER_THAN:
        case GREATER_THAN_EQUALS:{
          ;
          break;
          }
        default:
          jj_la1[4] = jj_gen;
          break label_1;
        }
        compareBooleanOperator();
code += " " + token.image + " ";
        jj_consume_token(INTEGER_LITERAL);
code += token.image;
      }
{if ("" != null) return code;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("compareBoolean");
    }
}

  static final public String booleanRepresentation() throws ParseException {
    trace_call("booleanRepresentation");
    try {
String code="",compare="";
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TRUE:{
        jj_consume_token(TRUE);
code="true";
        break;
        }
      case FALSE:{
        jj_consume_token(FALSE);
code="false";
        break;
        }
      case INTEGER_LITERAL:{
        compare = compareBoolean();
code=compare;
        break;
        }
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
{if ("" != null) return code;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("booleanRepresentation");
    }
}

  static final public String booleanExpression() throws ParseException {
    trace_call("booleanExpression");
    try {
String code="",operatorLoop,booLoop;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TRUE:{
        jj_consume_token(TRUE);
        break;
        }
      case FALSE:{
        jj_consume_token(FALSE);
        break;
        }
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
code+=token.image;
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case AND:
        case OR:{
          ;
          break;
          }
        default:
          jj_la1[7] = jj_gen;
          break label_2;
        }
        operatorLoop = booleanOperator();
code += " " + operatorLoop + " ";
        booLoop = booleanRepresentation();
code += booLoop;
      }
{if ("" != null) return code;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("booleanExpression");
    }
}

  static final public String algebricExpression() throws ParseException {
    trace_call("algebricExpression");
    try {
String code="";
      jj_consume_token(INTEGER_LITERAL);
code += token.image;
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case PLUS:
        case MINUS:
        case MULTIPLY:
        case DIVIDE:
        case MODULO:{
          ;
          break;
          }
        default:
          jj_la1[8] = jj_gen;
          break label_3;
        }
        algebricOperator();
code += " " + token.image + " ";
        jj_consume_token(INTEGER_LITERAL);
code += token.image;
      }
{if ("" != null) return code;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("algebricExpression");
    }
}

  static final public String stringExpression() throws ParseException {
    trace_call("stringExpression");
    try {
String code="";
      jj_consume_token(STRING_LITERAL);
code += token.image;
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case PLUS:{
          ;
          break;
          }
        default:
          jj_la1[9] = jj_gen;
          break label_4;
        }
        jj_consume_token(PLUS);
code += " " + token.image + " ";
        jj_consume_token(STRING_LITERAL);
code += token.image;
      }
{if ("" != null) return code;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("stringExpression");
    }
}

  static final public String functionExpression() throws ParseException {
    trace_call("functionExpression");
    try {
String code="";
      jj_consume_token(READ);
code+="stdin.readLineSync()";
{if ("" != null) return code;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("functionExpression");
    }
}

  static final public String[] primaryExpression() throws ParseException {
    trace_call("primaryExpression");
    try {
String code="",ex="";
String exType="";
String possibleId=null;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case INTEGER_LITERAL:{
        ex = algebricExpression();
code=ex;exType="int";
        break;
        }
      case TRUE:
      case FALSE:{
        ex = booleanExpression();
code=ex;exType="bool";
        break;
        }
      case STRING_LITERAL:{
        ex = stringExpression();
code=ex;exType="String";
        break;
        }
      case READ:{
        ex = functionExpression();
code=ex;exType="function";
        break;
        }
      case IDENTIFIER:{
        jj_consume_token(IDENTIFIER);
code=token.image;possibleId=token.image;
        break;
        }
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
if(possibleId!=null) {
        String idType = checkVariableAndReturnType(possibleId);
        exType = idType;
  }
  String[] arr = {code,exType};
  {if ("" != null) return arr;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("primaryExpression");
    }
}

  static final public String declaration() throws ParseException {
    trace_call("declaration");
    try {
String code = "",typeValue="",id="";
  String[] ex;
      typeValue = type();
code += typeValue + " ";
      jj_consume_token(IDENTIFIER);
id=token.image;code += token.image;
      jj_consume_token(ASSIGN);
code += " = ";
      ex = primaryExpression();
code += ex[0];
      jj_consume_token(SEMICOLON);
code += ";\n";
addVariable(typeValue,id);
        String exType = ex[1];
        if(typeValue!=exType && exType!="function") {
         {if (true) throw new ParseException("A variavel com nome " + id + " foi declarada como sendo do tipo " + typeValue + " mas a expression declarada foi do tipo " + exType);}
        }
        {if ("" != null) return code;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("declaration");
    }
}

  static final public String atribution() throws ParseException {
    trace_call("atribution");
    try {
String code="",id="";String[] ex;
      jj_consume_token(IDENTIFIER);
code+=token.image;id=token.image;
      jj_consume_token(ASSIGN);
code+=token.image;
      ex = primaryExpression();
code += ex[0];
      jj_consume_token(SEMICOLON);
code += ";\n";
String idType = checkVariableAndReturnType(id);
        String exType = ex[1];
        if(idType!=exType && exType!="function") {
         {if (true) throw new ParseException("Tentou atribuir um valor do tipo " + exType + " para a variavel de nome " + id + " que foi declarada como sendo do tipo " + idType);}
        }
        {if ("" != null) return code;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("atribution");
    }
}

  static final public String printStatement() throws ParseException {
    trace_call("printStatement");
    try {
String code="";String[] ex;
      jj_consume_token(PRINT);
code+="print";
      jj_consume_token(LEFT_PAREN);
code+=token.image;
      ex = primaryExpression();
code+=ex[0];
      jj_consume_token(RIGHT_PAREN);
code+=token.image;
      jj_consume_token(SEMICOLON);
code += ";\n";
{if ("" != null) return code;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("printStatement");
    }
}

  static final public String statement() throws ParseException {
    trace_call("statement");
    try {
String code="",v="";
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case INTSYMBOL:
      case STRINGSYMBOL:
      case BOOLEAN:{
        v = declaration();
code=v;
        break;
        }
      case IFSYMBOL:{
        v = condition();
code=v;
        break;
        }
      case WHILESYMBOL:{
        v = whileLoop();
code=v;
        break;
        }
      case IDENTIFIER:{
        v = atribution();
code=v;
        break;
        }
      case PRINT:{
        v = printStatement();
code=v;
        break;
        }
      default:
        jj_la1[11] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
{if ("" != null) return code;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("statement");
    }
}

  static final public String codeBlock() throws ParseException {
    trace_call("codeBlock");
    try {
String code="",stats="";
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case PRINT:
        case IFSYMBOL:
        case WHILESYMBOL:
        case INTSYMBOL:
        case STRINGSYMBOL:
        case BOOLEAN:
        case IDENTIFIER:{
          ;
          break;
          }
        default:
          jj_la1[12] = jj_gen;
          break label_5;
        }
        stats = statement();
code+=stats;
      }
{if ("" != null) return code;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("codeBlock");
    }
}

  static final public String condition() throws ParseException {
    trace_call("condition");
    try {
String code="",block="",boo="",blockElse="";
      jj_consume_token(IFSYMBOL);
code+=token.image;
      jj_consume_token(LEFT_PAREN);
code+=token.image;
      boo = booleanExpression();
code+=boo;
      jj_consume_token(RIGHT_PAREN);
code+=token.image;
      jj_consume_token(LEFT_BRACE);
code+=token.image+"\n";
      block = codeBlock();
code+=block;
      jj_consume_token(RIGHT_BRACE);
code+=token.image+"\n";
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case ELSESYMBOL:{
        jj_consume_token(ELSESYMBOL);
code+=token.image;
        jj_consume_token(LEFT_BRACE);
code+=token.image+"\n";
        blockElse = codeBlock();
code+=blockElse;
        jj_consume_token(RIGHT_BRACE);
code+=token.image+"\n";
        break;
        }
      default:
        jj_la1[13] = jj_gen;
        ;
      }
{if ("" != null) return code;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("condition");
    }
}

//String forLoop(): {String code,block,dec,boo;} {
//<FORSYMBOL>{code+=token.image;}
//<LEFT_PAREN>{code+=token.image;}
//dec = declaration() {code+=dec;}
//(
// boo=booleanExpression() {code+=boo;}
// <SEMICOLON> {code += ";";}
//)
//
//}
  static final public 
String whileLoop() throws ParseException {
    trace_call("whileLoop");
    try {
String code="",block="",boo="",blockElse="";
      jj_consume_token(WHILESYMBOL);
code+=token.image;
      jj_consume_token(LEFT_PAREN);
code+=token.image;
      boo = booleanExpression();
code+=boo;
      jj_consume_token(RIGHT_PAREN);
code+=token.image;
      jj_consume_token(LEFT_BRACE);
code+=token.image+"\n";
      block = codeBlock();
code+=block;
      jj_consume_token(RIGHT_BRACE);
code+=token.image+"\n";
{if ("" != null) return code;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("whileLoop");
    }
}

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public JavaToDartTranspilerTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[14];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
	   jj_la1_init_0();
	   jj_la1_init_1();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0xe000,0x7e000000,0x7c0000,0x1800000,0x7e000000,0x30000,0x30000,0x1800000,0x7c0000,0x40000,0x30020,0xe4c0,0xe4c0,0x100,};
	}
	private static void jj_la1_init_1() {
	   jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x100,0x0,0x0,0x0,0x0,0x380,0x80,0x80,0x0,};
	}

  {
      enable_tracing();
  }
  /** Constructor with InputStream. */
  public JavaToDartTranspiler(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public JavaToDartTranspiler(java.io.InputStream stream, String encoding) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser.  ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new JavaToDartTranspilerTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public JavaToDartTranspiler(java.io.Reader stream) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser. ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new JavaToDartTranspilerTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new JavaToDartTranspilerTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public JavaToDartTranspiler(JavaToDartTranspilerTokenManager tm) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser. ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(JavaToDartTranspilerTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   trace_token(token, "");
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	   trace_token(token, " (in getNextToken)");
	 return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  static private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[42];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 14; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		   if ((jj_la1_1[i] & (1<<j)) != 0) {
			 la1tokens[32+j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 42; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  static private boolean trace_enabled;

/** Trace enabled. */
  static final public boolean trace_enabled() {
	 return trace_enabled;
  }

  static private int trace_indent = 0;
/** Enable tracing. */
  static final public void enable_tracing() {
	 trace_enabled = true;
  }

/** Disable tracing. */
  static final public void disable_tracing() {
	 trace_enabled = false;
  }

  static protected void trace_call(String s) {
	 if (trace_enabled) {
	   for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
	   System.out.println("Call:	" + s);
	 }
	 trace_indent = trace_indent + 2;
  }

  static protected void trace_return(String s) {
	 trace_indent = trace_indent - 2;
	 if (trace_enabled) {
	   for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
	   System.out.println("Return: " + s);
	 }
  }

  static protected void trace_token(Token t, String where) {
	 if (trace_enabled) {
	   for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
	   System.out.print("Consumed token: <" + tokenImage[t.kind]);
	   if (t.kind != 0 && !tokenImage[t.kind].equals("\"" + t.image + "\"")) {
		 System.out.print(": \"" + TokenMgrError.addEscapes(t.image) + "\"");
	   }
	   System.out.println(" at line " + t.beginLine + " column " + t.beginColumn + ">" + where);
	 }
  }

  static protected void trace_scan(Token t1, int t2) {
	 if (trace_enabled) {
	   for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
	   System.out.print("Visited token: <" + tokenImage[t1.kind]);
	   if (t1.kind != 0 && !tokenImage[t1.kind].equals("\"" + t1.image + "\"")) {
		 System.out.print(": \"" + TokenMgrError.addEscapes(t1.image) + "\"");
	   }
	   System.out.println(" at line " + t1.beginLine + " column " + t1.beginColumn + ">; Expected token: <" + tokenImage[t2] + ">");
	 }
  }

//  public changeVariable(String type,String identifier) throws ParseException {
//	checkVariable(identifier);
//	String typeName = symbolTable.get(identifier);
//	if(typeName!=type) {
//		throw new ParseException("Variavel " + identifier + " nao foi declarada.");
//	}
// }

}
