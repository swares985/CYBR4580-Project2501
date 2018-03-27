public class UserAccountWithString {
		private String accountName;
		private String password;
		
		public UserAccountWithString(String accountName, String password) {
			accountName = this.accountName;
			password = this.password;
		}
		
		public String getUsername() {
			return accountName;
		}
		
		public String getPassword() {
			return password;
		}
		
		public void dispose() {
			accountName = null;
			password = null;
		}
	}