package com.pranavaeet.constants;

public final class URL_CONSTANTS {

	private URL_CONSTANTS() {}
	
	public static final String ERROR_400 = "/400";
	public static final String ERROR_403 = "/403";
	public static final String ERROR_404 = "/404";
	public static final String ERROR_500 = "/500";
	
	public static final String SIGNIN = "/signin";
	public static final String REDIRECT_SIGNIN = "redirect:/signin";
	public static final String LOGIN = "/login";
	public static final String LOGOUT = "/login?logout";
	public static final String LOGIN_ERROR = "/login?error";
	public static final String SESSION_EXPIRED = "/login?session";
	public static final String REDIRECT_SESSION_EXPIRED = "redirect:/login?session";
	public static final String IFRAME_SESSION_EXPIRED = "/sessionExpiredWithinIframe";
	public static final String REDIRECT_IFRAME_SESSION_EXPIRED = "redirect:/sessionExpiredWithinIframe";
	
	public static final String HOME_PAGE = "/home";
	public static final String PRIVACY = "/privacy";
	public static final String TERMS = "/terms";
	public static final String CHANGE_PASSWORD = "/change-password";
	public static final String UPDATE_PASSWORD = "updatePassword";
	public static final String FORGOT_PASSWORD = "/forgot-password";
	public static final String RESET_PASSWORD = "/resetPassword";
	
	public static final String MY_PROFILE = "/my-profile";
	public static final String UPDATE_USER_PROFILE = "updateUserProfile";
	public static final String UPDATE_USER_ADDRESS = "updateUserAddress";
	public static final String UPDATE_USER_PICTURE = "updateUserPicture";
	
	public static final String USER_HOME = "/user";
	
}
