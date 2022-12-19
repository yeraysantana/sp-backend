package com.sp.services.ledgerentries;

import com.sp.entities.Group;
import com.sp.entities.LedgerEntry;
import com.sp.entities.User;
import com.sp.payloads.users.UserLedgerEntryBalancePayload;
import com.sp.payloads.users.UserLedgerEntryPayload;
import com.sp.repositories.LedgerEntryRepository;
import com.sp.services.groups.IGroupService;
import com.sp.services.transaction.ITransactionService;
import com.sp.services.users.IUserService;
import com.sp.shared.utils.CustomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class LedgerEntryService implements ILedgerEntryService {
    private Logger logger = LoggerFactory.getLogger(LedgerEntryService.class);
    private CustomUtils customUtils;

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
    public Iterable<UserLedgerEntryPayload> getUserLedgerEntriesByIdTransaction(Long idTransaction) {
        ArrayList<LedgerEntry> ledgerEntriesList = ledgerEntryRepository.findByIdTransaction(idTransaction);
        ArrayList<UserLedgerEntryPayload> userLedgerEntriesBalanceList = new ArrayList<>();
        ledgerEntriesList.forEach(ledgerEntry -> {
            Optional<User> user = userService.getUser(ledgerEntry.getIdUser());
            Optional<Group> group = groupService.getGroup(ledgerEntry.getIdGroup());
            String userCompleteName = user.get().getName() + " " + user.get().getSurname();
            String groupName = group.get().getName();
            if(user.isPresent() && group.isPresent()){
                UserLedgerEntryPayload userLedgerEntryPayload =
                    new UserLedgerEntryPayload(
                            userCompleteName,
                            groupName,
                            ledgerEntry.getDescription(),
                            ledgerEntry.getPayType(),
                            ledgerEntry.getAmount(),
                            ledgerEntry.getCreatedAt().toString()
                    );
                userLedgerEntriesBalanceList.add(userLedgerEntryPayload);
            }
        });
        return userLedgerEntriesBalanceList;
    }

    @Override
    public Iterable<UserLedgerEntryBalancePayload> getUserLedgerEntriesBalancesByIdGroup(Long idGroup) {
        ArrayList<UserLedgerEntryBalancePayload> userLedgerEntriesBalanceList = new ArrayList<>();
        return userLedgerEntriesBalanceList;
    }

    @Override
    public LedgerEntry addLedgerEntry(LedgerEntry payment) {
        return ledgerEntryRepository.save(payment);
    }
}
