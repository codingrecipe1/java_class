package ch15_interface.ex02;

import java.util.HashMap;
import java.util.Map;

public class MemberRepositoryMap implements MemberRepository {
    private static Map<Long, MemberDTO> memberDTOMap = new HashMap<>();

    @Override
    public boolean save(MemberDTO memberDTO) {
        MemberDTO dto = memberDTOMap.put(memberDTO.getId(), memberDTO);
        if (dto == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public MemberDTO login(String memberEmail, String memberPassword) {
        for (Long i : memberDTOMap.keySet()) {
            if (memberEmail.equals(memberDTOMap.get(i).getMemberEmail()) &&
                    memberPassword.equals(memberDTOMap.get(i).getMemberPassword())) {
                return memberDTOMap.get(i);
            }
        }
        return null;
    }

    @Override
    public Map<Long, MemberDTO> findAll() {
        return memberDTOMap;
    }

    @Override
    public boolean update(String loginEmail, String mobile) {
        for (Long i : memberDTOMap.keySet()) {
            if (loginEmail.equals(memberDTOMap.get(i).getMemberEmail())) {
                memberDTOMap.get(i).setMemberMobile(mobile);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String loginEmail) {
        for (Long i : memberDTOMap.keySet()) {
            if (loginEmail.equals(memberDTOMap.get(i).getMemberEmail())) {
                memberDTOMap.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean emailCheck(String memberEmail) {
        for (Long i : memberDTOMap.keySet()) {
            if (memberEmail.equals(memberDTOMap.get(i).getMemberEmail())) {
                return false;
            }
        }
        return true;
    }
}
