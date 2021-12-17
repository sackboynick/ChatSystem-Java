package viewmodel;

import model.Model;

/**
 * The class is used to store, to construct and to obtain always the same objects of the ViewModel that the system needs.
 * @author Group8-SEP2
 * @version 1.0.0 2021
 */

public class ViewModelFactory {
    private final AddFriendViewModel addFriendViewModel;
    private final ChatsViewModel chatsViewModel;
    private final CreateGroupViewModel createGroupViewModel;
    private final FriendsListViewModel friendsListViewModel;
    private final LogInViewModel logInViewModel;
    private final PrivateChatViewModel privateChatViewModel;
    private final RegisterViewModel registerViewModel;
    private final GroupChatViewModel groupChatViewModel;
    private final ForwardMessageViewModel forwardMessageViewModel;
    private final ParticipantListViewModel participantListViewModel;

    /**
     * One-argument constructor which initializes all the ViewModel objects.
     * @param model The model to which all the viewModel files will delegate some methods.
     */
    public ViewModelFactory(Model model){
        this.addFriendViewModel =new AddFriendViewModel(model);
        this.chatsViewModel =new ChatsViewModel(model);
        this.createGroupViewModel =new CreateGroupViewModel(model);
        this.friendsListViewModel =new FriendsListViewModel(model);
        this.logInViewModel =new LogInViewModel(model);
        this.privateChatViewModel =new PrivateChatViewModel(model);
        this.registerViewModel =new RegisterViewModel(model);
        this.groupChatViewModel=new GroupChatViewModel(model);
        this.forwardMessageViewModel=new ForwardMessageViewModel(model);
        this.participantListViewModel=new ParticipantListViewModel(model);
    }

    public ParticipantListViewModel getParticipantListViewModel() {
        return participantListViewModel;
    }

    public ForwardMessageViewModel getForwardMessageViewModel() {
        return forwardMessageViewModel;
    }

    /**
     * Getter for the Login ViewModel.
     * @return LoginViewModel object of the ViewModel.
     */
    public AddFriendViewModel getAddFriendViewModel() {
        return addFriendViewModel;
    }

    /**
     * Getter for the SignUp ViewModel.
     * @return SignUpViewModel object of the ViewModel.
     */
    public ChatsViewModel getChatsViewModel() {
        return chatsViewModel;
    }

    /**
     * Getter for the HomePage ViewModel.
     * @return HomePageViewModel object of the ViewModel.
     */
    public CreateGroupViewModel getCreateGroupViewModel() {
        return createGroupViewModel;
    }

    /**
     * Getter for the UserView ViewModel.
     * @return UserViewViewModel object of the ViewModel.
     */
    public FriendsListViewModel getFriendsListViewModel() {
        return friendsListViewModel;
    }

    /**
     * Getter for the OffersList ViewModel.
     * @return OffersListViewModel object of the ViewModel.
     */
    public LogInViewModel getLogInViewModel() {
        return logInViewModel;
    }

    /**
     * Getter for the PublishOffer ViewModel.
     * @return PublishOfferViewModel object of the ViewModel.
     */
    public PrivateChatViewModel getPrivateChatViewModel() {
        return privateChatViewModel;
    }

    /**
     * Getter for the OfferView ViewModel.
     * @return OfferViewViewModel object of the ViewModel.
     */
    public RegisterViewModel getRegisterViewModel() {
        return registerViewModel;
    }


    /**
     * Getter for the RentingList ViewModel.
     * @return RentingListViewModel object of the ViewModel.
     */
    public GroupChatViewModel getGroupChatViewModel() {
        return groupChatViewModel;
    }


}
