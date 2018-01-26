package com.example.deepanshuaggarwal.crazycalculator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
TextView tv1;
Button one;

    double expression=0f;
    String express;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button zero;
    Button del;
    Button clear;
    Button plus;
    Button minus;
    Button into;
    Button divide;
    Button power;
    Button equal;
    Button dot;
    Button obr;
    Button cbr;
    public static double getResult(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv1=findViewById(R.id.expression);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        one=findViewById(R.id.one);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                express=tv1.getText().toString();
                express=express+"1";
                tv1.setText(express);


            }
        });
        two=findViewById(R.id.two);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                express=tv1.getText().toString();
                express=express+"2";
                tv1.setText(express);


            }
        });
        three=findViewById(R.id.three);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                express=tv1.getText().toString();
                express=express+"3";
                tv1.setText(express);


            }
        });
        four=findViewById(R.id.four);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                express=tv1.getText().toString();
                express=express+"4";tv1.setText(express);


            }
        });
        five=findViewById(R.id.five);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                express=tv1.getText().toString();
                express=express+"5";tv1.setText(express);


            }
        });
        six=findViewById(R.id.six);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                express=tv1.getText().toString();
                express=express+"6";tv1.setText(express);


            }
        });
        seven=findViewById(R.id.seven);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                express=tv1.getText().toString();
                express=express+"7";tv1.setText(express);


            }
        });
        eight=findViewById(R.id.eight);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                express=tv1.getText().toString();
                express=express+"8";tv1.setText(express);


            }
        });
        nine=findViewById(R.id.nine);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                express=tv1.getText().toString();
                express=express+"9";tv1.setText(express);


            }
        });
        zero=findViewById(R.id.zero);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                express=tv1.getText().toString();
                express=express+"0";tv1.setText(express);


            }
        });

        del=findViewById(R.id.del);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                express=tv1.getText().toString();
               if(express.length()!=0){ express=express.substring(0,express.length()-1);}
                tv1.setText(express);


            }
        });
        clear=findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                express=tv1.getText().toString();
                express="";
                tv1.setText(express);


            }
        });

        plus=findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                express=tv1.getText().toString();
                express=express+"+";
                tv1.setText(express);


            }
        });
        minus=findViewById(R.id.minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                express=tv1.getText().toString();
                express=express+"-";
                tv1.setText(express);


            }
        });
        into=findViewById(R.id.into);
        into.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                express=tv1.getText().toString();
                express=express+"*";
                tv1.setText(express);


            }
        });
        divide=findViewById(R.id.divide);
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                express=tv1.getText().toString();
                express=express+"/";
                tv1.setText(express);


            }
        });
        power=findViewById(R.id.power);
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                express=tv1.getText().toString();
                express=express+"^";
                tv1.setText(express);


            }
        });
        equal=findViewById(R.id.equal);
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Status","Result called");
                Double i=getResult(express);
                express=Double.toString(i);
tv1.setText(express);
            }
        });
        dot=findViewById(R.id.dot);
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                express=tv1.getText().toString();
                if(express.charAt(express.length()-1)!='.'){
                express=express+".";}
                tv1.setText(express);
            }
        });
        obr=findViewById(R.id.obr);
        obr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                express=express+"(";
                tv1.setText(express);
            }
        });
        cbr=findViewById(R.id.cbr);
        cbr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                express=express+")";
                tv1.setText(express);
            }
        });







    }
}
