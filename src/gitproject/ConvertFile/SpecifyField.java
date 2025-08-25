package gitproject.ConvertFile;

/**
 * 項目情報クラス
 */
public class SpecifyField {
	// 項目名
	private final String fieldName;
	// バイト開始位置
	private final int fieldByteStartIndex;
	// バイト数
	private final int fieldByteLength;
	// 必須
	private final boolean fieldValueRequired;
	// 半角
	private final boolean halfWidth;

	/**
	 * コンストラクタ
	 * @param fieldName
	 * @param fieldByteStartIndex
	 * @param fieldByteLength 
	 */
	public SpecifyField(String fieldName, int fieldByteStartIndex, int fieldByteLength,
			boolean fieldValueRequired, boolean halfWidthOnly) {
		this.fieldName = fieldName;
		this.fieldByteStartIndex = fieldByteStartIndex;
		this.fieldByteLength = fieldByteLength;
		this.fieldValueRequired = fieldValueRequired;
		this.halfWidth = halfWidthOnly;

	}

	public String getFieldName() {
		return fieldName;
	}

	public int getFieldStartIndex() {
		return fieldByteStartIndex;
	}

	public int getFieldLength() {
		return fieldByteLength;
	}

	public boolean getFieldValueRequired() {
		return fieldValueRequired;
	}
	public boolean getHalfWidth() {
		return halfWidth;
	}


}
