package answer;


public class Entry_Huffman {
	private int    frequency;  // 빈도 수
	private String word;       // 이파리 노드의 문자 또는 내부노드의 합성된 문자열 
	private Entry_Huffman  left;       // 왼쪽 자식
	private Entry_Huffman  right;      // 오른쪽 자식
	private String code;       // 허프만 코드
	
	public Entry_Huffman (int newFreq, String newValue, Entry_Huffman l, Entry_Huffman r, String s){
		frequency = newFreq;
		word  = newValue;
		left  = l;
		right = r;
		code  = s;
	}
	public int    getKey()   { return frequency; }
	public String getValue() { return word; }
	public String getCode()  { return code; }
	public Entry_Huffman  getLeft()  { return left; }
	public Entry_Huffman  getRight() { return right; }

	public void   setCode(String newCode) { code = newCode; }
}