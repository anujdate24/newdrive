
import java.util.*;
public class Nfa{

public static String removeDuplicates(String input){
   String result = "";
   for (int i = 0; i < input.length(); i++) {
       if(!result.contains(String.valueOf(input.charAt(i)))) {
           result += String.valueOf(input.charAt(i));
       }
   }
   return result;
}
public static void main(String args[])
{

Scanner scanner = new Scanner(System.in);
int number;
System.out.println("Enter the number of states");
number = scanner.nextInt();
String states[] = new String[number];
System.out.println("Enter the names of states");
for(int i=0;i<number;i++)
{
states[i]=scanner.next();
}
for(int i=0;i<number;i++)
{
System.out.println(states[i]);
}

int number_lang;
System.out.println("Enter the number of alphabets in the language");
number_lang=scanner.nextInt();
String input[]=new String[number_lang];
System.out.println("Enter the alphabets in the language");
for(int i=0;i<number_lang;i++)
{
input[i]=scanner.next();
}

Map<String,String> nfa = new HashMap();

for(int i=0;i<number;i++)
{
for(int j=0;j<number_lang;j++)
{
System.out.println("Enter output of "+states[i]+" on "+input[j]);
String output = scanner.next();


if(output.equals("N"))
output="";
nfa.put(states[i]+input[j], output);
}
}

Set<Map.Entry<String, String>> set = nfa.entrySet();
System.out.println("Given NFA is ");
for(Map.Entry<String,String> me:set)
{

String statein = me.getKey();

System.out.println(statein.charAt(0)+" on "+statein.charAt(1)+" : "+me.getValue());

}
List<String> dfastates = new ArrayList<>();
dfastates.add(states[0]);
Map<String,String> dfa = new HashMap<>();
System.out.println("DFA ");
for(int k=0;k<dfastates.size();k++)
{
String statearray[]=dfastates.get(k).split("");

for(int i=0;i<number_lang;i++)
{
String st="";
for(int j=0;j<statearray.length;j++)
{
String s=statearray[j]+input[i];
st=st+nfa.get(s);
}
st=removeDuplicates(st);
if(dfastates.contains(st))
{

}
else
{
dfastates.add(st);
}
dfa.put(dfastates.get(k)+input[i], st);
System.out.println(dfastates.get(k) +" on "+input[i]+" : "+st);
}
}

}
}
