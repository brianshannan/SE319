grammar RPN;

@members {
    int val = 0;
    int a = 0;
    int b = 0;
    int c = 0;
}

start
 	 : (expr ';' {System.out.println(val); val=0;} )+
 	 ;

expr
   : INT {a = $INT.int; System.out.println("a="+a);}
     INT {b = $INT.int; System.out.println("b="+b);}
     '+' {val = a+b;} ;

INT : [0-9]+  ;
WS : [ \r\t\n]+ -> skip ;
