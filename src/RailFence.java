
public class RailFence {
	public static void main(String[] args) {
		
		String message = "WEAREDISCOVEREDFLEEATONCE";
		int depth = 3;
		String encrypt = Encrypt(message, depth);
		System.out.println(encrypt);
		String decrypt = Decrypt(encrypt, depth);
		System.out.println(decrypt);
	}
	
	public static String Encrypt(String message, int depth) {
		int msgLen = message.length(), i, j, k = -1, row = 0, col = 0;
		char railMatrix[][] = new char [depth][msgLen];
	    for(i = 0; i < depth; ++i)
	        for(j = 0; j < msgLen; ++j)
	            railMatrix[i][j] = '\n';
	    for(i = 0; i < msgLen; ++i){
	        railMatrix[row][col++] = message.charAt(i);
	        if(row == 0 || row == depth-1)
	            k= k * (-1);
	        row = row + k;
	    }	 
	    String encrypt = "";
	    for(i = 0; i < depth; ++i)
	        for(j = 0; j < msgLen; ++j)
	            if(railMatrix[i][j] != '\n')
	    			encrypt = encrypt+railMatrix[i][j];
	    return encrypt;
	}
	public static String Decrypt(String message, int depth) {
		int msgLen = message.length(), i, j, k = -1, row = 0, col = 0, m = 0;
		char railMatrix[][] = new char [depth][msgLen];
	 
	    for(i = 0; i < depth; ++i)
	        for(j = 0; j < msgLen; ++j)
	            railMatrix[i][j] = '\n';
	    for(i = 0; i < msgLen; ++i){
	        railMatrix[row][col++] = '*';
	        if(row == 0 || row == depth-1)
	            k= k * (-1);
	        row = row + k;
	    }
	    for(i = 0; i < depth; ++i)
	        for(j = 0; j < msgLen; ++j)
	            if(railMatrix[i][j] == '*')
	                railMatrix[i][j] = message.charAt(m++);
	 
	    row = col = 0;
	    k = -1;
	 
	    String decrypt = "";
	    for(i = 0; i < msgLen; ++i){
	    	decrypt = decrypt+railMatrix[row][col++];
	        if(row == 0 || row == depth-1)
	            k= k * (-1);
	 
	        row = row + k;
	    }
	    return decrypt;
	}
}
