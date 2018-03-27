public class UserAccountWithCharArray {
		private String accountName;
		private char[] password;
		
		public UserAccountWithCharArray(String accountName, char[] password) {
			accountName = this.accountName;
			password = this.password;
		}
		
		public String getUsername() {
			return accountName;
		}
		
		public char[] getPassword() {
			return password;
		}
		
		public void dispose() {
			accountName = null;

			for (int i=0; i < password.length; i++) {
				password[i] = '0';
			}
		}
	}