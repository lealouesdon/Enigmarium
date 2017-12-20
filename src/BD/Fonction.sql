Create Function insertion(/*un insert*/) as 
Begin 
If (Select /*primary key*/ from /*table du insert*/ = /*primary key du insert */ )
    /*pas d'insertion*/
Else 
    /*insertion*/
End if;
END;

$$LANGUAGE'plpgsql';
