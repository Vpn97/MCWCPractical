package com.apkzube.mcwcpractical.PracticalActivity;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.apkzube.mcwcpractical.R;

import java.util.LinkedList;

public class Practical_6 extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnequ, btndot,
            btnadd, btnsub, btnmul, btndiv, btndel, btnclr;
    TextView txtdisplay;

    char[] ch;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_6);
        this.getSupportActionBar().setTitle("Calculator");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        allocation();
        setEvent();
    }

    private void allocation() {
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btndot = (Button) findViewById(R.id.btndot);
        btnequ = (Button) findViewById(R.id.btnequ);
        btndel = (Button) findViewById(R.id.btndel);
        btnadd = (Button) findViewById(R.id.btnadd);
        btnsub = (Button) findViewById(R.id.btnsub);
        btnmul = (Button) findViewById(R.id.btnmul);
        btndiv = (Button) findViewById(R.id.btndiv);
        btnclr =  findViewById(R.id.btnclr);
        txtdisplay =  findViewById(R.id.txtdisplay);
    }

    private void setEvent() {
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtdisplay.setText(txtdisplay.getText() + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtdisplay.setText(txtdisplay.getText() + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtdisplay.setText(txtdisplay.getText() + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtdisplay.setText(txtdisplay.getText() + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtdisplay.setText(txtdisplay.getText() + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtdisplay.setText(txtdisplay.getText() + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtdisplay.setText(txtdisplay.getText() + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtdisplay.setText(txtdisplay.getText() + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtdisplay.setText(txtdisplay.getText() + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtdisplay.setText(txtdisplay.getText() + "9");
            }
        });

        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addoperator(btndot);
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addoperator(btnadd);
            }
        });

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addoperator(btnsub);
            }
        });

        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addoperator(btnmul);
            }
        });

        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addoperator(btndiv);
            }
        });

        btnequ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = txtdisplay.getText().toString();
                if (s.length() > 0) {
                    if (s.charAt(0) == '-' || s.charAt(0) == '.')
                        txtdisplay.setText("0" + txtdisplay.getText());
                    addoperator(btnequ);
                    calculate();
                }
            }
        });

        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = txtdisplay.getText().toString();
                if (s.length() > 0) {
                    txtdisplay.setText(s.substring(0, s.length() - 1));
                }
                if(s.equals("Infinity")) {
                    txtdisplay.setText("");
                }
            }
        });

        btnclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtdisplay.setText("");
            }
        });
    }

    private void addoperator(Button id) {
        String s = txtdisplay.getText().toString();
        ch = s.toCharArray();
        i = ch.length - 1;

        if (s.length() > 0) {
            ch = s.toCharArray();
            i = ch.length - 1;

            if (s.length() == 1 && ch[0] == '-') {
                if (id == btnsub)
                    txtdisplay.setText("" + "-");
                else
                    txtdisplay.setText("");
            } else {
                if (ch[i] == '+' || ch[i] == '-' || ch[i] == 'x' || ch[i] == '/' || ch[i] == '.')
                    txtdisplay.setText(s.substring(0, s.length() - 1));
                if (id != btnequ)
                    txtdisplay.setText(txtdisplay.getText() + id.getText().toString());
            }
        } else {
            if (id == btnsub || id == btndot)
                txtdisplay.setText(txtdisplay.getText() + id.getText().toString());
        }
    }

    private void calculate() {

        String s = txtdisplay.getText().toString();
        char[] ch;
        LinkedList b = new LinkedList();
        int i, low = 0, high, j = 0;
        ch = s.toCharArray();

        for (i = 0; i < s.length(); i++) {
            if (ch[i] == '+' || ch[i] == '-' || ch[i] == 'x' || ch[i] == '/' || i == s.length() - 1) {
                if (i == s.length() - 1)
                    i = s.length();

                high = i;
                b.add(j, Float.parseFloat(s.substring(low, high)));

                if (i != s.length() && ch[0] != '-') {
                    low = i + 1;
                    j++;
                    b.add(j, ch[i]);
                    j++;
                }
            }
        }
        while (b.contains('/')) {
            j = b.indexOf('/');
            b.set(j - 1, (float) b.get(j - 1) / (float) b.get(j + 1));
            b.remove(j);
            b.remove(j);
        }
        while (b.contains('x')) {
            j = b.indexOf('x');
            b.set(j - 1, (float) b.get(j - 1) * (float) b.get(j + 1));
            b.remove(j);
            b.remove(j);
        }
        while (b.contains('-')) {
            j = b.indexOf('-');
            b.set(j - 1, (float) b.get(j - 1) - (float) b.get(j + 1));
            b.remove(j);
            b.remove(j);
        }
        while (b.contains('+')) {
            j = b.indexOf('+');
            b.set(j - 1, (float) b.get(j - 1) + (float) b.get(j + 1));
            b.remove(j);
            b.remove(j);
        }
        txtdisplay.setText("" + b.get(0));
    }

}
