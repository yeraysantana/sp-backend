package com.sp.services.ledgerentries;

import com.sp.entities.Group;
import com.sp.entities.LedgerEntry;
import com.sp.entities.User;
import com.sp.objects.UserLedgerEntryBalance;
import com.sp.repositories.GroupRepository;
import com.sp.repositories.LedgerEntryRepository;
import com.sp.repositories.UserRepository;
import com.sp.services.groups.IGroupService;
import com.sp.services.users.IUserService;
import com.sp.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class LedgerEntryService implements ILedgerEntryService {

    @Autowired
    private LedgerEntryRepository ledgerEntryRepository;
    @Autowired
    private IUserService userService;
    @Autowired
    private IGroupService groupService;

    @Override
    public Iterable<LedgerEntry> getLedgerEntries() {
        return ledgerEntryRepository.findAll();
    }

    @Override
    public Optional<LedgerEntry> getLedgerEntry(Long id) {
        return ledgerEntryRepository.findById(id);
    }

    @Override
    public Iterable<UserLedgerEntryBalance> getUserLedgerEntriesBalancesByIdTransaction(Long idTransaction) {
        ArrayList<LedgerEntry> ledgerEntriesList = ledgerEntryRepository.findByIdTransaction(idTransaction);
        ArrayList<UserLedgerEntryBalance> userLedgerEntriesBalanceList = new ArrayList<>();
        ledgerEntriesList.forEach(ledgerEntry -> {
            final Optional<User> user = userService.getUser(ledgerEntry.getIdUser());
            final Optional<Group> group = groupService.getGroup(ledgerEntry.getIdGroup());
            if(user.isPresent() && group.isPresent()){
                final UserLedgerEntryBalance userLedgerEntryBalance = new UserLedgerEntryBalance(user, group, ledgerEntry.getPayType(), ledgerEntry.getAmount());
                userLedgerEntriesBalanceList.add(userLedgerEntryBalance);
            }
        });
        return userLedgerEntriesBalanceList;
    }

    @Override
    public LedgerEntry addLedgerEntry(LedgerEntry payment) {
        return ledgerEntryRepository.save(payment);
    }
}
