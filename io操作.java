/*
	 * ��ȡ�����ļ�
	 */
	public static String read(String file) {
		String s = null;
		StringBuffer sb = new StringBuffer();
		File f = new File(file);
		if (f.exists()) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						new FileInputStream(f)));
				while ((s = br.readLine()) != null) {
					sb.append(s);
				}
				return s = sb.toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("�ļ�������!");
		}
		return s = null;
	}

	/*
	 * д�������ļ�
	 */
	public static void write(String path, String content) {
		String s = new String();
		String s1 = new String();

		try {
			File f = new File(path);

			if (f.exists()) {
				System.out.println("�ļ�����");
			} else {
				System.out.println("�ļ������ڣ����ڴ���...");
				if (f.createNewFile()) {
					System.out.println("�ļ������ɹ���");
				} else {
					System.out.println("�ļ�����ʧ�ܣ�");
				}
			}

			BufferedReader input = new BufferedReader(new FileReader(f));

			while ((s = input.readLine()) != null) {
				s1 += s + "/n";
			}

			System.out.println("�ļ����ݣ�" + s1);
			input.close();
			s1 += content;
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(s1);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}