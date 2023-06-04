package com.example.auth.member.service

import com.example.auth.common.exception.InvalidInputException
import com.example.auth.member.dto.MemberDtoRequest
import com.example.auth.member.entity.Member
import com.example.auth.member.repository.MemberRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Transactional
@Service
class MemberService(
    private val memberRepository: MemberRepository
) {
    fun signUp(memberDtoRequest: MemberDtoRequest): Boolean {
        var member: Member? = memberRepository.findByLoginId(memberDtoRequest.loginId)
        if (member != null) {
            throw InvalidInputException("loginId", "이미 등록된 ID 입니다.")
        }

        member = memberDtoRequest.toEntity()
        memberRepository.save(member)

        return true
    }
}