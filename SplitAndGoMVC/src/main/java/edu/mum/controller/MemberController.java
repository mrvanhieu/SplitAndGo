package edu.mum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Authority;
import edu.mum.domain.Member;
import edu.mum.service.AuthorityService;
import edu.mum.service.MemberService;

@Controller
@RequestMapping("/members")
public class MemberController {

	@Autowired
	MemberService memberService;

	@Autowired
	AuthorityService authorityService;

	@RequestMapping()
	public String getMembers(Model model) {
		model.addAttribute("members", memberService.findAll());
		return "member/members";
	}

	@RequestMapping("/addMember")
	public String addMember(@ModelAttribute("member") Member member) {
		return "member/addMember";
	}

	@RequestMapping(value = "/addMember", method = RequestMethod.POST)
	public String addMember(@ModelAttribute("member") @Valid Member member, BindingResult result) {
		if (result.hasErrors()) {
			return "member/addMember";
		}
		memberService.save(member);
		return "redirect:/members";
	}

	@RequestMapping("/editMember/{id}")
	public String editMember(Model model, @PathVariable("id") Long id) {
		model.addAttribute("member", memberService.findOne(id));
		return "member/editMember";
	}

	@RequestMapping(value = "/editMember", method = RequestMethod.POST)
	public String editMember(@ModelAttribute("member") @Valid Member member, BindingResult result) {
		if (result.hasErrors()) {
			return "member/editMember";
		}
		memberService.update(member);
		return "redirect:/members";
	}

	@RequestMapping("/deleteMember/{id}")
	public String deleteMember(@PathVariable("id") Long id) {
		memberService.delete(id);
		return "redirect:/members";
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(List.class, "credential.authorities", new CustomCollectionEditor(List.class) {
			protected Object convertElement(Object element) {
				if (element instanceof Authority) {
					System.out.println("Converting from Authority to Authority: " + element);
					return element;
				}
				if (element instanceof Long) {
					Authority authority = authorityService.findOne((Long)element);
					System.out.println("Looking up authority for id " + element + ": " + authority);
					return authority;
				}
				if (element instanceof String) {
					if (StringUtils.isEmpty(element)) {
						return null;
					}
					Authority authority = authorityService.findOne(Long.parseLong((String)element));
					System.out.println("Looking up authority for id " + element + ": " + authority);
					return authority;
				}
				System.out.println("Don't know what to do with: " + element);
				return null;
			}
		});
	}

}
