package com.tsv.implementation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tsv.implementation.dao.UserRepository;
import com.tsv.implementation.dto.UserLoginDTO;
import com.tsv.implementation.Entity.User;
import com.tsv.implementation.service.DefaultUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;


@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private DefaultUserService userService;
	
	@Autowired
	UserRepository userRepo;
    
    @ModelAttribute("user")
    public UserLoginDTO userLoginDTO() {
        return new UserLoginDTO();
    }
    
	@GetMapping
	public String login() {
		return "login";
	}
	
	@PostMapping
	public void loginUser(@ModelAttribute("user") 
	UserLoginDTO userLoginDTO) {
		System.out.println("UserDTO"+userLoginDTO);
		 userService.loadUserByUsername(userLoginDTO.getUsername());
	}
	@GetMapping("/otpVerification")
	public String otpSent(Model model,UserLoginDTO userLoginDTO) {
		model.addAttribute("otpValue", userLoginDTO);
		return "otpScreen";
		
	}
	@PostMapping("/otpVerification")
	public String otpVerification(@ModelAttribute("otpValue") UserLoginDTO userLoginDTO  , Authentication authentication , HttpServletRequest request , HttpServletResponse response) throws IOException {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
		User users = userRepo.findByEmail(user.getUsername());
        String redirectUrl = null;
		if(users.getOtp() == userLoginDTO.getOtp())
		{
			/*//////////////////////////////////////////////////////////////////////////////////////////////////////*/


			Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
			for(GrantedAuthority grantedAuthority : authorities)
			{
				if(grantedAuthority.getAuthority().equals("USER"))
				{
					 return "redirect:/verifyLink";//redirectUrl = "/verifyLink";
					//break;
				} else if (grantedAuthority.getAuthority().equals("HOST")) {
					 return "redirect:/link";//redirectUrl= "/link";
					//break;
				}

			}
			if(redirectUrl == null)
			{
				throw  new IllegalStateException();
			}
			//new DefaultRedirectStrategy().sendRedirect(request , response , redirectUrl);
			return "redirect:redirectUrl";     //redirect:/dashboard
			/*/////////////////////////////////////////////////////////////////////////////////////////////////////*/
		}
		else
			return "redirect:/login/otpVerification?error";
	}
	
}
