import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
	public static Map<String, String[]> codex = new HashMap<>();
	public static ArrayList<String> subscripts = new ArrayList<>();
	public static ArrayList<String> uniqueSubscripts = new ArrayList<>();
	public static ArrayList<String> allWords = new ArrayList<>();
	public static ArrayList<String[]> wordAsValues = new ArrayList<>();
	
	public static void main(String []args){
		subscripts.add("1");
		subscripts.add("2");
		subscripts.add("3");
        String word = "okay";
        System.out.println("Word: "+word);
        
        ArrayList<String> wordBasesOnly = new ArrayList<>();
        ArrayList<String> allPossible = new ArrayList<>();

        populateCodex();
        createWordBasesOnly(word, wordBasesOnly);
        String[] wordSubsOnly = createWordSubsOnly(word);

        convertWordToValues(word);
        printWordAsValues(wordAsValues);
        
        System.out.println("sequential sub values of word "+Arrays.toString(wordSubsOnly));  
        System.out.println("unique Subscripts: "+uniqueSubscripts);
        
        //Use uniqueSubscripts if you want only results fitting given subscript values
        //allPossible = getCombinations(word.length(), uniqueSubscripts);
        
        //Use subscripts if you want all possible combinations from all possible subscript values
        allPossible = getCombinations(word.length(), subscripts);
        setAllWords(wordBasesOnly, allPossible);
        System.out.println("Total possible decodings: "+allWords.size());
        for(int i = 0; i < allWords.size(); i++) System.out.println(allWords.get(i));
     }

	public static void setAllWords(ArrayList<String> bases, ArrayList<String> allpossible) {
		String s;
		for(int j = 0; j < allpossible.size(); j++) { 
			s = "";
			for(int i = 0; i < allpossible.get(0).length(); i++) s += decodeValue(bases.get(i),Character.toString(allpossible.get(j).charAt(i)));
			allWords.add(s);
		}
	}
	
	public static void printAllWords(ArrayList<String> bases, ArrayList<String> allpossible) {
		for(int j = 0; j < allpossible.size(); j++) {
			for(int i = 0; i < allpossible.get(0).length(); i++)
				System.out.print(decodeValue(bases.get(i),Character.toString(allpossible.get(j).charAt(i))));		
			System.out.println();
		}
	}
	
	public static void convertWordToValues(String word) {
		 for(int i = 0; i<word.length();i++) {
	            System.out.println("adding ["+codex.get(Character.toString(word.charAt(i)))[0]+","+codex.get(Character.toString(word.charAt(i)))[1]+"] ("+
	            word.charAt(i)+") to wordAsValues (object: "+codex.get(Character.toString(word.charAt(i)))+")");
	            wordAsValues.add(codex.get(Character.toString(word.charAt(i))));
	        }	
	}
	
	
	public static String decodeValue(String x, String y){
		String[] s = new String[]{x,y};
		return getKey(codex, s);
	}
	
	public static <K, V> String getKey(Map<String, String[]> map, String[] value) {
	    for (Entry<String, String[]> entry : map.entrySet()) {
	        if(entry.getValue()[0].equals(value[0]) && entry.getValue()[1].equals(value[1]) ) {
	        	return entry.getKey();
	        }
	    }
	    return null;
	}
	
	public static ArrayList<String> getCombinations(int n, ArrayList<String> subs) {
		//Create temp arrays for holding headers
		ArrayList<String> headers = new ArrayList<>();
		ArrayList<String> outputs = new ArrayList<>();
		//Load given subscripts as first headers
		for(int p = 0; p < subs.size(); p++) headers.add(subs.get(p));
		//If input length n is only one, just print input subscripts
		if(n==1) {
			System.out.println(headers);
			return headers;
		}
		//Otherwise its logic time baby
		else {	
				for(int j = 0; j<n-1; j++) {
					outputs.clear();
					System.out.println("Headers (pass "+j+"): "+headers.toString());
					for(int l = 0; l<headers.size(); l++) 
						for(int k = 0; k < subs.size(); k++)
							outputs.add(headers.get(l)+subs.get(k));
					headers.clear();
					headers.addAll(outputs);
				}
				System.out.println("Final Output:"+headers.toString());
				return headers;
				
		}
		
	}

	//prints by converting any string into its value pairs
	public static void printWordAsValuePairs(String s) {
		String o = "";
		for(int i = 0; i<s.length(); i++) {
			o += "["+codex.get(Character.toString(s.charAt(i)))[0]+","+codex.get(Character.toString(s.charAt(i)))[1]+"]";
		}
		System.out.println(o);
	}
	
	//prints by iterating through existing array of value pairs 
	public static void printWordAsValues(ArrayList<String[]> w) {
		System.out.print("Words as values: ");
		for(int i = 0; i < w.size(); i++) {
			System.out.print("["+w.get(i)[0]+","+w.get(i)[1]+"] ");
		}
		System.out.println();
	}

	public static String[] createWordSubsOnly(String word) {
		String[] wso = new String[word.length()];
		for(int i=0; i<word.length(); i++) {
			System.out.println("adding "+codex.get(Character.toString(word.charAt(i)))[1]+" to wordSubsOnly");
			wso[i] = codex.get(Character.toString(word.charAt(i)))[1];
			if(!uniqueSubscripts.contains(wso[i]))	uniqueSubscripts.add(wso[i]);
		}
		return wso;	
	}

	public static void createWordBasesOnly(String word, ArrayList<String> wbo) {
		for(int i=0; i<word.length(); i++) {
			System.out.println("adding "+codex.get(Character.toString(word.charAt(i)))[0]+" to wordBasesOnly");
			wbo.add(codex.get(Character.toString(word.charAt(i)))[0]);
		}
	}	

	public static void populateCodex(){
    	codex.put("a", new String[] {"1","1"});
    	codex.put("b", new String[] {"2","1"});
    	codex.put("c", new String[] {"3","1"});
    	codex.put("d", new String[] {"4","1"});
    	codex.put("e", new String[] {"5","1"});
    	codex.put("f", new String[] {"6","1"});
    	codex.put("g", new String[] {"7","1"});
    	codex.put("h", new String[] {"8","1"});
    	codex.put("i", new String[] {"9","1"});
    	codex.put("j", new String[] {"1","2"});
    	codex.put("k", new String[] {"2","2"});
    	codex.put("l", new String[] {"3","2"});
    	codex.put("m", new String[] {"4","2"});
    	codex.put("n", new String[] {"5","2"});
    	codex.put("o", new String[] {"6","2"});
    	codex.put("p", new String[] {"7","2"});
    	codex.put("q", new String[] {"8","2"});
    	codex.put("r", new String[] {"9","2"});
    	codex.put("s", new String[] {"1","3"});
    	codex.put("t", new String[] {"2","3"});
    	codex.put("u", new String[] {"3","3"});
    	codex.put("v", new String[] {"4","3"});
    	codex.put("w", new String[] {"5","3"});
    	codex.put("x", new String[] {"6","3"});
    	codex.put("y", new String[] {"7","3"});
    	codex.put("z", new String[] {"8","3"});
    	codex.put("-", new String[] {"9","3"});
    }	
	
}
