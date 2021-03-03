package aris.ath.springsec.Model;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class AuthResponse
{
    public boolean isValid()
    {
        return valid;
    }

    public void setValid(boolean valid)
    {
        this.valid = valid;
    }

    @Nullable
    public String getUid()
    {
        return uid;
    }

    public void setUid(@Nullable String uid)
    {
        this.uid = uid;
    }

    @Nullable
    public String getRealm()
    {
        return realm;
    }

    public void setRealm(@Nullable String realm)
    {
        this.realm = realm;
    }

    @Nullable
    public String getSessionUid()
    {
        return sessionUid;
    }

    public void setSessionUid(@Nullable String sessionUid)
    {
        this.sessionUid = sessionUid;
    }

    @Nullable
    boolean valid;

    @Nullable
    String uid;

    @Nullable
    String realm;

    @Nullable
    String sessionUid;

}
