package antlr.srcfiles;// $ANTLR 3.4 Z:\\BAI-4\\CI\\artihmetic_puzzle.g 2013-06-04 13:35:38

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class artihmetic_puzzleParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ERGEBNIS", "GLEICH", "HORIZONTAL", "HVOPERATIONS", "LETTER", "MINUS", "OPERAND1", "OPERAND2", "PLUS", "RAETSEL", "START", "VERTIKAL", "ZAHL", "'+'", "','", "'-'", "'['", "'].'", "']H['", "']V['"
    };

    public static final int EOF=-1;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int ERGEBNIS=4;
    public static final int GLEICH=5;
    public static final int HORIZONTAL=6;
    public static final int HVOPERATIONS=7;
    public static final int LETTER=8;
    public static final int MINUS=9;
    public static final int OPERAND1=10;
    public static final int OPERAND2=11;
    public static final int PLUS=12;
    public static final int RAETSEL=13;
    public static final int START=14;
    public static final int VERTIKAL=15;
    public static final int ZAHL=16;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public artihmetic_puzzleParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public artihmetic_puzzleParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return artihmetic_puzzleParser.tokenNames; }
    public String getGrammarFileName() { return "Z:\\BAI-4\\CI\\artihmetic_puzzle.g"; }


    public static class starta_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "starta"
    // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:25:1: starta : '[' r0= zahl ',' r1= zahl ',' r2= zahl ',' r3= zahl ',' r4= zahl ',' r5= zahl ',' r6= zahl ',' r7= zahl ',' r8= zahl ']V[' v1= op ',' v2= op ',' v3= op ']H[' h1= op ',' h2= op ',' h3= op '].' -> ^( RAETSEL ^( $v1 $r0 $r1 $r2) ^( $v1 $r3 $r4 $r5) ^( $v3 $r6 $r7 $r8) ^( $h1 $r0 $r3 $r6) ^( $h2 $r1 $r4 $r7) ^( $h3 $r2 $r5 $r8) ) ;
    public final starta_return starta() throws RecognitionException {
        starta_return retval = new starta_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal1=null;
        Token char_literal2=null;
        Token char_literal3=null;
        Token char_literal4=null;
        Token char_literal5=null;
        Token char_literal6=null;
        Token char_literal7=null;
        Token char_literal8=null;
        Token char_literal9=null;
        Token string_literal10=null;
        Token char_literal11=null;
        Token char_literal12=null;
        Token string_literal13=null;
        Token char_literal14=null;
        Token char_literal15=null;
        Token string_literal16=null;
        zahl_return r0 =null;

        zahl_return r1 =null;

        zahl_return r2 =null;

        zahl_return r3 =null;

        zahl_return r4 =null;

        zahl_return r5 =null;

        zahl_return r6 =null;

        zahl_return r7 =null;

        zahl_return r8 =null;

        op_return v1 =null;

        op_return v2 =null;

        op_return v3 =null;

        op_return h1 =null;

        op_return h2 =null;

        op_return h3 =null;


        CommonTree char_literal1_tree=null;
        CommonTree char_literal2_tree=null;
        CommonTree char_literal3_tree=null;
        CommonTree char_literal4_tree=null;
        CommonTree char_literal5_tree=null;
        CommonTree char_literal6_tree=null;
        CommonTree char_literal7_tree=null;
        CommonTree char_literal8_tree=null;
        CommonTree char_literal9_tree=null;
        CommonTree string_literal10_tree=null;
        CommonTree char_literal11_tree=null;
        CommonTree char_literal12_tree=null;
        CommonTree string_literal13_tree=null;
        CommonTree char_literal14_tree=null;
        CommonTree char_literal15_tree=null;
        CommonTree string_literal16_tree=null;
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleTokenStream stream_22=new RewriteRuleTokenStream(adaptor,"token 22");
        RewriteRuleTokenStream stream_18=new RewriteRuleTokenStream(adaptor,"token 18");
        RewriteRuleTokenStream stream_23=new RewriteRuleTokenStream(adaptor,"token 23");
        RewriteRuleSubtreeStream stream_zahl=new RewriteRuleSubtreeStream(adaptor,"rule zahl");
        RewriteRuleSubtreeStream stream_op=new RewriteRuleSubtreeStream(adaptor,"rule op");
        try {
            // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:25:8: ( '[' r0= zahl ',' r1= zahl ',' r2= zahl ',' r3= zahl ',' r4= zahl ',' r5= zahl ',' r6= zahl ',' r7= zahl ',' r8= zahl ']V[' v1= op ',' v2= op ',' v3= op ']H[' h1= op ',' h2= op ',' h3= op '].' -> ^( RAETSEL ^( $v1 $r0 $r1 $r2) ^( $v1 $r3 $r4 $r5) ^( $v3 $r6 $r7 $r8) ^( $h1 $r0 $r3 $r6) ^( $h2 $r1 $r4 $r7) ^( $h3 $r2 $r5 $r8) ) )
            // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:25:10: '[' r0= zahl ',' r1= zahl ',' r2= zahl ',' r3= zahl ',' r4= zahl ',' r5= zahl ',' r6= zahl ',' r7= zahl ',' r8= zahl ']V[' v1= op ',' v2= op ',' v3= op ']H[' h1= op ',' h2= op ',' h3= op '].'
            {
            char_literal1=(Token)match(input,20,FOLLOW_20_in_starta67);  
            stream_20.add(char_literal1);


            pushFollow(FOLLOW_zahl_in_starta70);
            r0=zahl();

            state._fsp--;

            stream_zahl.add(r0.getTree());

            char_literal2=(Token)match(input,18,FOLLOW_18_in_starta71);  
            stream_18.add(char_literal2);


            pushFollow(FOLLOW_zahl_in_starta74);
            r1=zahl();

            state._fsp--;

            stream_zahl.add(r1.getTree());

            char_literal3=(Token)match(input,18,FOLLOW_18_in_starta75);  
            stream_18.add(char_literal3);


            pushFollow(FOLLOW_zahl_in_starta78);
            r2=zahl();

            state._fsp--;

            stream_zahl.add(r2.getTree());

            char_literal4=(Token)match(input,18,FOLLOW_18_in_starta79);  
            stream_18.add(char_literal4);


            pushFollow(FOLLOW_zahl_in_starta82);
            r3=zahl();

            state._fsp--;

            stream_zahl.add(r3.getTree());

            char_literal5=(Token)match(input,18,FOLLOW_18_in_starta83);  
            stream_18.add(char_literal5);


            pushFollow(FOLLOW_zahl_in_starta86);
            r4=zahl();

            state._fsp--;

            stream_zahl.add(r4.getTree());

            char_literal6=(Token)match(input,18,FOLLOW_18_in_starta87);  
            stream_18.add(char_literal6);


            pushFollow(FOLLOW_zahl_in_starta90);
            r5=zahl();

            state._fsp--;

            stream_zahl.add(r5.getTree());

            char_literal7=(Token)match(input,18,FOLLOW_18_in_starta91);  
            stream_18.add(char_literal7);


            pushFollow(FOLLOW_zahl_in_starta94);
            r6=zahl();

            state._fsp--;

            stream_zahl.add(r6.getTree());

            char_literal8=(Token)match(input,18,FOLLOW_18_in_starta95);  
            stream_18.add(char_literal8);


            pushFollow(FOLLOW_zahl_in_starta98);
            r7=zahl();

            state._fsp--;

            stream_zahl.add(r7.getTree());

            char_literal9=(Token)match(input,18,FOLLOW_18_in_starta99);  
            stream_18.add(char_literal9);


            pushFollow(FOLLOW_zahl_in_starta102);
            r8=zahl();

            state._fsp--;

            stream_zahl.add(r8.getTree());

            string_literal10=(Token)match(input,23,FOLLOW_23_in_starta103);  
            stream_23.add(string_literal10);


            pushFollow(FOLLOW_op_in_starta106);
            v1=op();

            state._fsp--;

            stream_op.add(v1.getTree());

            char_literal11=(Token)match(input,18,FOLLOW_18_in_starta107);  
            stream_18.add(char_literal11);


            pushFollow(FOLLOW_op_in_starta110);
            v2=op();

            state._fsp--;

            stream_op.add(v2.getTree());

            char_literal12=(Token)match(input,18,FOLLOW_18_in_starta111);  
            stream_18.add(char_literal12);


            pushFollow(FOLLOW_op_in_starta114);
            v3=op();

            state._fsp--;

            stream_op.add(v3.getTree());

            string_literal13=(Token)match(input,22,FOLLOW_22_in_starta115);  
            stream_22.add(string_literal13);


            pushFollow(FOLLOW_op_in_starta118);
            h1=op();

            state._fsp--;

            stream_op.add(h1.getTree());

            char_literal14=(Token)match(input,18,FOLLOW_18_in_starta119);  
            stream_18.add(char_literal14);


            pushFollow(FOLLOW_op_in_starta122);
            h2=op();

            state._fsp--;

            stream_op.add(h2.getTree());

            char_literal15=(Token)match(input,18,FOLLOW_18_in_starta123);  
            stream_18.add(char_literal15);


            pushFollow(FOLLOW_op_in_starta126);
            h3=op();

            state._fsp--;

            stream_op.add(h3.getTree());

            string_literal16=(Token)match(input,21,FOLLOW_21_in_starta127);  
            stream_21.add(string_literal16);


            // AST REWRITE
            // elements: r8, h2, r1, h1, v1, r8, r0, r4, h3, r3, v1, r7, r2, r3, r1, r6, r7, v3, r5, r0, r4, r5, r2, r6
            // token labels: 
            // rule labels: v1, retval, v3, r6, r7, r8, r0, r1, h1, r2, r3, r4, h3, r5, h2
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_v1=new RewriteRuleSubtreeStream(adaptor,"rule v1",v1!=null?v1.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_v3=new RewriteRuleSubtreeStream(adaptor,"rule v3",v3!=null?v3.tree:null);
            RewriteRuleSubtreeStream stream_r6=new RewriteRuleSubtreeStream(adaptor,"rule r6",r6!=null?r6.tree:null);
            RewriteRuleSubtreeStream stream_r7=new RewriteRuleSubtreeStream(adaptor,"rule r7",r7!=null?r7.tree:null);
            RewriteRuleSubtreeStream stream_r8=new RewriteRuleSubtreeStream(adaptor,"rule r8",r8!=null?r8.tree:null);
            RewriteRuleSubtreeStream stream_r0=new RewriteRuleSubtreeStream(adaptor,"rule r0",r0!=null?r0.tree:null);
            RewriteRuleSubtreeStream stream_r1=new RewriteRuleSubtreeStream(adaptor,"rule r1",r1!=null?r1.tree:null);
            RewriteRuleSubtreeStream stream_h1=new RewriteRuleSubtreeStream(adaptor,"rule h1",h1!=null?h1.tree:null);
            RewriteRuleSubtreeStream stream_r2=new RewriteRuleSubtreeStream(adaptor,"rule r2",r2!=null?r2.tree:null);
            RewriteRuleSubtreeStream stream_r3=new RewriteRuleSubtreeStream(adaptor,"rule r3",r3!=null?r3.tree:null);
            RewriteRuleSubtreeStream stream_r4=new RewriteRuleSubtreeStream(adaptor,"rule r4",r4!=null?r4.tree:null);
            RewriteRuleSubtreeStream stream_h3=new RewriteRuleSubtreeStream(adaptor,"rule h3",h3!=null?h3.tree:null);
            RewriteRuleSubtreeStream stream_r5=new RewriteRuleSubtreeStream(adaptor,"rule r5",r5!=null?r5.tree:null);
            RewriteRuleSubtreeStream stream_h2=new RewriteRuleSubtreeStream(adaptor,"rule h2",h2!=null?h2.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 26:3: -> ^( RAETSEL ^( $v1 $r0 $r1 $r2) ^( $v1 $r3 $r4 $r5) ^( $v3 $r6 $r7 $r8) ^( $h1 $r0 $r3 $r6) ^( $h2 $r1 $r4 $r7) ^( $h3 $r2 $r5 $r8) )
            {
                // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:26:6: ^( RAETSEL ^( $v1 $r0 $r1 $r2) ^( $v1 $r3 $r4 $r5) ^( $v3 $r6 $r7 $r8) ^( $h1 $r0 $r3 $r6) ^( $h2 $r1 $r4 $r7) ^( $h3 $r2 $r5 $r8) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(RAETSEL, "RAETSEL")
                , root_1);

                // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:26:16: ^( $v1 $r0 $r1 $r2)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(stream_v1.nextNode(), root_2);

                adaptor.addChild(root_2, stream_r0.nextTree());

                adaptor.addChild(root_2, stream_r1.nextTree());

                adaptor.addChild(root_2, stream_r2.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:26:38: ^( $v1 $r3 $r4 $r5)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(stream_v1.nextNode(), root_2);

                adaptor.addChild(root_2, stream_r3.nextTree());

                adaptor.addChild(root_2, stream_r4.nextTree());

                adaptor.addChild(root_2, stream_r5.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:26:61: ^( $v3 $r6 $r7 $r8)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(stream_v3.nextNode(), root_2);

                adaptor.addChild(root_2, stream_r6.nextTree());

                adaptor.addChild(root_2, stream_r7.nextTree());

                adaptor.addChild(root_2, stream_r8.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:26:83: ^( $h1 $r0 $r3 $r6)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(stream_h1.nextNode(), root_2);

                adaptor.addChild(root_2, stream_r0.nextTree());

                adaptor.addChild(root_2, stream_r3.nextTree());

                adaptor.addChild(root_2, stream_r6.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:26:107: ^( $h2 $r1 $r4 $r7)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(stream_h2.nextNode(), root_2);

                adaptor.addChild(root_2, stream_r1.nextTree());

                adaptor.addChild(root_2, stream_r4.nextTree());

                adaptor.addChild(root_2, stream_r7.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:26:130: ^( $h3 $r2 $r5 $r8)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(stream_h3.nextNode(), root_2);

                adaptor.addChild(root_2, stream_r2.nextTree());

                adaptor.addChild(root_2, stream_r5.nextTree());

                adaptor.addChild(root_2, stream_r8.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "starta"


    public static class zahl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "zahl"
    // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:28:1: zahl : ( LETTER )* -> ^( ZAHL ( LETTER )* ) ;
    public final zahl_return zahl() throws RecognitionException {
        zahl_return retval = new zahl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LETTER17=null;

        CommonTree LETTER17_tree=null;
        RewriteRuleTokenStream stream_LETTER=new RewriteRuleTokenStream(adaptor,"token LETTER");

        try {
            // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:28:6: ( ( LETTER )* -> ^( ZAHL ( LETTER )* ) )
            // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:28:8: ( LETTER )*
            {
            // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:28:8: ( LETTER )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==LETTER) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:28:8: LETTER
            	    {
            	    LETTER17=(Token)match(input,LETTER,FOLLOW_LETTER_in_zahl248);  
            	    stream_LETTER.add(LETTER17);


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            // AST REWRITE
            // elements: LETTER
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 28:16: -> ^( ZAHL ( LETTER )* )
            {
                // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:28:19: ^( ZAHL ( LETTER )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ZAHL, "ZAHL")
                , root_1);

                // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:28:26: ( LETTER )*
                while ( stream_LETTER.hasNext() ) {
                    adaptor.addChild(root_1, 
                    stream_LETTER.nextNode()
                    );

                }
                stream_LETTER.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "zahl"


    public static class op_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "op"
    // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:29:1: op : ( ( '+' -> PLUS ) | ( '-' -> MINUS ) );
    public final op_return op() throws RecognitionException {
        op_return retval = new op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal18=null;
        Token char_literal19=null;

        CommonTree char_literal18_tree=null;
        CommonTree char_literal19_tree=null;
        RewriteRuleTokenStream stream_19=new RewriteRuleTokenStream(adaptor,"token 19");
        RewriteRuleTokenStream stream_17=new RewriteRuleTokenStream(adaptor,"token 17");

        try {
            // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:29:4: ( ( '+' -> PLUS ) | ( '-' -> MINUS ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==17) ) {
                alt2=1;
            }
            else if ( (LA2_0==19) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:29:6: ( '+' -> PLUS )
                    {
                    // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:29:6: ( '+' -> PLUS )
                    // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:29:7: '+'
                    {
                    char_literal18=(Token)match(input,17,FOLLOW_17_in_op266);  
                    stream_17.add(char_literal18);


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 29:11: -> PLUS
                    {
                        adaptor.addChild(root_0, 
                        (CommonTree)adaptor.create(PLUS, "PLUS")
                        );

                    }


                    retval.tree = root_0;

                    }


                    }
                    break;
                case 2 :
                    // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:29:20: ( '-' -> MINUS )
                    {
                    // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:29:20: ( '-' -> MINUS )
                    // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:29:21: '-'
                    {
                    char_literal19=(Token)match(input,19,FOLLOW_19_in_op274);  
                    stream_19.add(char_literal19);


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 29:25: -> MINUS
                    {
                        adaptor.addChild(root_0, 
                        (CommonTree)adaptor.create(MINUS, "MINUS")
                        );

                    }


                    retval.tree = root_0;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "op"

    // Delegated rules


 

    public static final BitSet FOLLOW_20_in_starta67 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_zahl_in_starta70 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_starta71 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_zahl_in_starta74 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_starta75 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_zahl_in_starta78 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_starta79 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_zahl_in_starta82 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_starta83 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_zahl_in_starta86 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_starta87 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_zahl_in_starta90 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_starta91 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_zahl_in_starta94 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_starta95 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_zahl_in_starta98 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_starta99 = new BitSet(new long[]{0x0000000000800100L});
    public static final BitSet FOLLOW_zahl_in_starta102 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_starta103 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_op_in_starta106 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_starta107 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_op_in_starta110 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_starta111 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_op_in_starta114 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_starta115 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_op_in_starta118 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_starta119 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_op_in_starta122 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_starta123 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_op_in_starta126 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_starta127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LETTER_in_zahl248 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_17_in_op266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_op274 = new BitSet(new long[]{0x0000000000000002L});

}